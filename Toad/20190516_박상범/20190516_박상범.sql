select * from test11, (select rownum rno from test11 where rownum<5)

select rownum rno from test11 where rownum<5
  
SELECT 
       coll,dept,
       DECODE(rno,1,'1�г�'
                 ,2,'2�г�'
                 ,3,'3�г�'
                 ,4,'4�г�') �г�, rno
  FROM test11, (select rownum rno from test11 where rownum<5)
  
SELECT 
       coll,dept,
       DECODE(rno,1,'1�г�'
                 ,2,'2�г�'
                 ,3,'3�г�'
                 ,4,'4�г�') �г�,
       DECODE(rno,1, fre
                  ,2,sup
                  ,3,jun
                  ,4,sen) ����
  FROM test11, (select rownum rno from test11 where rownum<5)
ORDER BY �г� asc, dept
