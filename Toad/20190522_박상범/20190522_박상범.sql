SELECT * FROM t_orderbasket

------------날짜, 소계, 총계를 더미테이블의 로우넘을 이용해 한테이블에 표현해보자
SELECT *
  FROM t_orderbasket
      ,(SELECT rownum rno FROM t_orderbasket WHERE rownum<4)
      
SELECT DECODE(rno, 1, indate_vc
                  , 2, '소계'
                  , 3, '총계')
  FROM t_orderbasket
      ,(SELECT rownum rno FROM t_orderbasket WHERE rownum<4)
      
SELECT DECODE(rno, 1, indate_vc
                  , 2, '소계'
                  , 3, '총계')
      , gubun_vc, qty_nu, (qty_nu*price_nu)
  FROM t_orderbasket
      ,(SELECT rownum rno FROM t_orderbasket WHERE rownum<4)
     
-------------- 그룹바이로 정렬해봄 - 문제 : 총계에는 물품구분이 들어가면 안됨
SELECT DECODE(rno, 1, indate_vc
                  , 2, '소계'
                  , 3, '총계') 판매날짜
      , gubun_vc 물품구분, sum(qty_nu) 판매개수, sum((qty_nu*price_nu)) 판매가격
  FROM t_orderbasket
      ,(SELECT rownum rno FROM t_orderbasket WHERE rownum<4)
GROUP BY DECODE(rno, 1, indate_vc
                  , 2, '소계'
                  , 3, '총계'), gubun_vc
ORDER BY DECODE(rno, 1, indate_vc
                  , 2, '소계'
                  , 3, '총계') ASC
              
-----총계값에 널을 넣을려면 gubun_vc를 2차 가공하자!

SELECT DECODE(rno, 1, indate_vc
                  , 2, '소계'
                  , 3, '총계') 판매날짜
      ,DECODE(rno, 1, gubun_vc
                  ,2, gubun_vc||'계'
                  ,3, null) 물품구분
      , SUM(qty_nu)||'개' 판매개수, SUM((qty_nu*price_nu))||' 원' 판매가격
  FROM t_orderbasket
      ,(SELECT rownum rno FROM t_orderbasket WHERE rownum<4)
GROUP BY DECODE(rno, 1, indate_vc
                  , 2, '소계'
                  , 3, '총계')
        ,DECODE(rno, 1, gubun_vc
                  ,2, gubun_vc||'계'
                  ,3, null)       
ORDER BY DECODE(rno, 1, indate_vc
                  , 2, '소계'
                  , 3, '총계')
        ,DECODE(rno, 1, gubun_vc
                  ,2, gubun_vc||'계'
                  ,3, null)