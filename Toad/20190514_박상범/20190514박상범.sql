문제1
김유신씨가 보유하고 있는 마일리지 포인트로 얻을 수
있는 상품 중 가장 포인트가 높은 상품명과 포인트를
출력하는 SQL문을 작성하시오.

1번 답지

SELECT name_vc "가장 높은 상품명", point_nu "해당 포인트"
    FROM t_giftpoint
   WHERE point_nu IN (SELECT max(P.point_nu) FROM t_giftmem M, t_giftpoint P 
                        WHERE M.point_nu >= P.point_nu AND M.name_vc='김유신');
2번 답지         
        
SELECT P.point_nu, P.name_vc, M.name_vc
    FROM (SELECT * FROM t_giftmem WHERE name_vc='김유신') M, t_giftpoint P       
   WHERE P.point_nu = (SELECT MAX(t_giftpoint.point_nu) 
                        FROM t_giftpoint
                        , (SELECT * FROM t_giftmem WHERE name_vc='김유신') M
                         WHERE M.point_nu>=t_giftpoint.point_nu)
                        
      
                        
FROM에 테이블을 두개 쓸 필요가 없다.

문제2
C:\웹스마트융합\01. 오라클_수업\오라클실습소스\SQL\04장
t_worktime테이블 추가하기

t_worktime에는 작업코드와 작업시간 정보가 담겨 있다.
rank()와 같은 함수를 사용하지 말고
작업시간이 짧게 걸리는 시간 순서대로 1부터 15까지의
순위를 매겨서 출력하시오.

출력결과

작업코드  작업시간  순위
---------------------------

SELECT a.time_nu , b.time_nu
FROM t_worktime a, t_worktime b
ORDER BY a.time_nu asc, b.time_nu;

WHERE one.time_nu>two.time_nu
GROUP BY two.seq_vc

ORDER BY one.time_nu , two.time_nu;


 
SELECT workcd_vc 작업코드, b.time_nu 작업시간
       , (SELECT count(*) +1
         FROM t_worktime  WHERE time_nu < b.time_nu) rank
     FROM t_worktime b
     ORDER BY rank asc
     
SELECT workcd_vc 작업코드, b.time_nu 작업시간
       , (SELECT count(*) +1
         FROM t_worktime  WHERE time_nu < b.time_nu) rank
     FROM t_worktime b
     
이해가 전혀 되지 않음.