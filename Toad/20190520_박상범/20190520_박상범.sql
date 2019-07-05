SELECT * FROM test02

SELECT * FROM test02, (SELECT rownum rno FROM test02)

SELECT rownum rno, cdate, amt, crate FROM test02
         
--------------

SELECT rno, cdate 일자, amt 금액, crate 당일환율
  FROM (SELECT rownum rno, cdate, amt, crate 
        FROM test02 at
       union all
       SELECT rownum rno, cdate, amt, crate 
         FROM test02 bt )
         
------------------ 디코드를 사용하는게 아니다? 인라인뷰와 rno값을 건들여 보자

SELECT rownum+1 FROM emp

--------------------------

SELECT *
  FROM (SELECT rownum rno, cdate, amt, crate FROM test02) t1
       ,(SELECT rownum rno, cdate, amt, crate FROM test02) t2
 WHERE t1.rno=t2.rno-1
-----------------------

SELECT *
  FROM (SELECT rownum rno, cdate, amt, crate FROM test02) t1
       ,(SELECT rownum rno, cdate, amt, crate FROM test02) t2
       
 WHERE t2.rno = t1.rno-1
 
------------------------------------ 답 1
SELECT t2.cdate 일자, t2.amt 금액, t1.crate 환율, t2.amt*t1.crate 환화금액
  FROM (SELECT rownum rno, cdate, amt, crate FROM test02) t1
       ,(SELECT rownum rno, cdate, amt, crate FROM test02) t2
 WHERE t1.rno = t2.rno-1
 
 --------------------------------------------------------- 답 2
        
 SELECT t1.cdate 일자, t1.amt 금액, t2.crate 환율, t1.amt*t2.crate 환화금액
  FROM (SELECT rownum rno, cdate, amt, crate FROM test02) t1
       ,(SELECT rownum rno, cdate, amt, crate FROM test02) t2
 WHERE t2.rno = t1.rno-1