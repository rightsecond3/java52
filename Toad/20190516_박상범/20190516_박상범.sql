select * from test11, (select rownum rno from test11 where rownum<5)

select rownum rno from test11 where rownum<5
  
SELECT 
       coll,dept,
       DECODE(rno,1,'1학년'
                 ,2,'2학년'
                 ,3,'3학년'
                 ,4,'4학년') 학년, rno
  FROM test11, (select rownum rno from test11 where rownum<5)
  
SELECT 
       coll,dept,
       DECODE(rno,1,'1학년'
                 ,2,'2학년'
                 ,3,'3학년'
                 ,4,'4학년') 학년,
       DECODE(rno,1, fre
                  ,2,sup
                  ,3,jun
                  ,4,sen) 정원
  FROM test11, (select rownum rno from test11 where rownum<5)
ORDER BY 학년 asc, dept
