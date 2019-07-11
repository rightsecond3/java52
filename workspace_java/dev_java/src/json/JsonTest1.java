package json;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class JsonTest1 {
	public static void jsonFormat(String key3) {
		JsonParser jsonPar = new JsonParser();
		JsonArray array = jsonPar.parse(key3).getAsJsonArray();
		for(JsonElement el:array) {
			System.out.println("JsonTest1 : "+el);
			String temp = el.toString();
			JsonParser jsonPar1 = new JsonParser();
			//key를 Json 포멧으로 바꿔줌
			JsonObject jsonObj = jsonPar.parse(temp).getAsJsonObject();
			String value = jsonObj.get("name").toString();
			System.out.println("JsonTest1 : "+value);
		}
	}
	
	public static void main(String[] args) {
		//밑의 문자열은 json 포맷이 아니다.
		//why - 대괄호가 없기 때문
		//그러므로 Gson으로 파싱이 되지 않음.
		String key = "{\"key\":\"abcd1234\"}";
		String key2 = "{\"key\":\"abcd1234\",\"name\":\"김유신\"}";
		System.out.println("main : "+key);
		//밑의 코드는 Json 포멧
		String key3 = "[{\"key\":\"abcd1234\",\"name\":\"김유신\",\"age\":30}]";
		JsonParser jsonPar = new JsonParser();
		//key를 Json 포멧으로 바꿔줌
		JsonObject jsonObj = jsonPar.parse(key2).getAsJsonObject();
		String value = jsonObj.get("name").toString();
		System.out.println("main : "+value);
		jsonFormat(key3);
	}

}
