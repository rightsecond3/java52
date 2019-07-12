package naver.captcha;

import java.awt.Container;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class APIExamCaptchaAll {
    String clientId = "9r4FNQcya1CRyE7XrYw6";//애플리케이션 클라이언트 아이디값";
    String clientSecret = "0D9i2HYTFn";//애플리케이션 클라이언트 시크릿값";
    String key = null;
    BufferedImage bimg = null;
    //** 키발급
    public void APIExamcaptcahNkey() {
    	try {
    		String code = "0";
    		String apiURL = "https://openapi.naver.com/v1/captcha/nkey?code=" + code;
    		//네이버 웹서버에서 제공하는 캡챠서비스를 이요하기 위해 키 발급 url을 선언
    		//자바코드에서 웹서버에 페이지를 요청해야 하므로 URL 객체를 생성
            URL url = new URL(apiURL);
            //그 요청 객체를 활용하여 Http 통신 프로토콜 커넥션을 연결함.
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            //전송방식을 정함
            con.setRequestMethod("GET");
            //요청 속성에 아이디와 비번을 같이 넘김
            con.setRequestProperty("X-Naver-Client-Id", clientId);
            con.setRequestProperty("X-Naver-Client-Secret", clientSecret);
            //네이버 웹서버에서 요청을 받아서 처리하고 그 결과 HTTP상태 코드값(200,404,500)
            int responseCode = con.getResponseCode();
            BufferedReader br;
            if(responseCode==200) { // 정상 호출
            	//네이버 서버에서 생성한 응답 메시지를 읽기 위해서 InputStreamReader생성
                br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            } else {  // 에러 발생
                br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
            }
            String inputLine; //읽어 들인 한줄을 담을 변수 선언
            //String은 원본이 변하지 않으므로 여러 메시지를 담으려면 StringBuffer생성
            StringBuffer response = new StringBuffer();
            //반복문에서 null이 아닐때 까지 읽어서 저장
            while ((inputLine = br.readLine()) != null) {
            	//StringBuffer에 담긴 문자열을 붙인다.
                response.append(inputLine);
            }
            br.close();//StringBuffer 사용 종료 후 닫아줌
            System.out.println(response.toString());
            key = response.toString().substring(8, response.toString().length()-2);
            APIExamCaptcahImage();
            //System.out.println(key);
    	} catch(Exception e) {
    		e.printStackTrace();
    	}
    }
    //** 캡차 이미지 수신
    public void APIExamCaptcahImage() {
		try {
			String apiURL = "https://openapi.naver.com/v1/captcha/ncaptcha.bin?key=" + key;
			URL url = new URL(apiURL);
			HttpURLConnection con = (HttpURLConnection)url.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("X-Naver-Client-Id", clientId);
			con.setRequestProperty("X-Naver-Client-Secret", clientSecret);
			int responseCode = con.getResponseCode();
			BufferedReader br;
			if(responseCode==200) { // 정상 호출
				InputStream is = con.getInputStream();
				bimg = ImageIO.read(is);
				int read = 0;
				//네이버 서버에서 생성한 이미지 정보를 받아옴.
				//저장할 공간 생성
				byte[] bytes = new byte[1024];
				// 랜덤한 이름으로 파일 생성
				String tempname = Long.valueOf(new Date().getTime()).toString();
				//File은 파일명을 클래스로 만들어주는 객체임
				//그러나 파일만 생성되는 것이지 내용까지 담기는 건 아님.
				File f = new File("tempname" + ".jpg");
				//파라미터로 받은 이름으로 파일 생성
				f.createNewFile();
				OutputStream outputStream = new FileOutputStream(f);
				while ((read =is.read(bytes)) != -1) {
					//1)읽어들인 내용을 담을 저장소 주소번지, 2)0:처음부터 담아라, 3)무엇을 담을 것인가
					outputStream.write(bytes, 0, read);
				}
				is.close();
				//* 이미지 띄우기
		        JFrame jf_captcha = new JFrame();
		        //경로로 설정 할 경우 해당 경로가 refresh되지 않아서 똑같은 이미지 만을 가져오기 때문에
		        //버퍼드 이미지에서 가져온 이미지를 바로 넣어줘야 한다
		        JLabel jl_captcha = new JLabel(new ImageIcon(bimg));
		        Container cont = jf_captcha.getContentPane();
		        if(jl_captcha!=null) {
		        	cont.remove(jl_captcha);
		        }
		        jf_captcha.add(jl_captcha);
		        cont.revalidate();
		        jf_captcha.pack();
		        jf_captcha.setTitle("Captcha 이미지");
		        jf_captcha.setVisible(true);
				//* 사용자의 입력값 넣어주기
				APIExamCaptchaNkeyResult();
				//System.out.println(result);
			} else { // 에러 발생
				br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
				String inputLine;
				StringBuffer response = new StringBuffer();
				while ((inputLine = br.readLine()) != null) {
					response.append(inputLine);
				}
				br.close();
				System.out.println(response.toString());
			}
		} catch (Exception e) {
			System.out.println(e);
		}
    }
    //** 값을 비교하여 처리 결과 받아오기
    public void APIExamCaptchaNkeyResult() {
		try {
		//* 사용자가 입력한 문자값 받기
		Scanner sc = new Scanner(System.in);
		System.out.println("해당 문자를 입력하세요.");
		String value = sc.next();
		String code = "1"; // 키 발급시 0,  캡차 이미지 비교시 1로 세팅
		String apiURL = "https://openapi.naver.com/v1/captcha/nkey?code=" + code +"&key="+ key + "&value="+ value;
		URL url = new URL(apiURL);
		//네이버 웹서버와 통신 하기 위한 클래스 생성 및 연결
		HttpURLConnection con = (HttpURLConnection)url.openConnection();
		con.setRequestMethod("GET");
		con.setRequestProperty("X-Naver-Client-Id", clientId);
		con.setRequestProperty("X-Naver-Client-Secret", clientSecret);
		int responseCode = con.getResponseCode();
		BufferedReader br;
		//서버에 요청한 결과가 정상적으로 처리되면 200번 반환 - HTTP 상태
		if(responseCode==200) { // 정상 호출
		    br = new BufferedReader(new InputStreamReader(con.getInputStream()));
		} else {  // 에러 발생
		    br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
		}
		String inputLine;
		StringBuffer response = new StringBuffer();
		//읽어들인 값이 null이 아닐때까지 반복
		while ((inputLine = br.readLine()) != null) {
		    response.append(inputLine);
		}
		br.close();
		//정상적(캡챠이미지에 적힌 문자열과 사용자가 입력한 문자열 같니?)로 처리가 되면
		System.out.println(response.toString());
		String result = response.toString().substring(10,15);//flase일때
		if(result.equals("false")) {
			APIExamcaptcahNkey();
		} else {
			System.out.println("성공");
		}
		} catch (Exception e) {
			
		    System.out.println(e);
		}
    }
	public static void main (String[] args) {
		APIExamCaptchaAll captcha = new APIExamCaptchaAll();
		captcha.APIExamcaptcahNkey();
	}
}
