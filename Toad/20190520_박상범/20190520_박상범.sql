SELECT * FROM test02

SELECT * FROM test02, (SELECT rownum rno FROM test02)

SELECT rownum rno, cdate, amt, crate FROM test02
         
--------------

SELECT rno, cdate ����, amt �ݾ�, crate ����ȯ��
  FROM (SELECT rownum rno, cdate, amt, crate 
        FROM test02 at
       union all
       SELECT rownum rno, cdate, amt, crate 
         FROM test02 bt )
         
------------------ ���ڵ带 ����ϴ°� �ƴϴ�? �ζ��κ�� rno���� �ǵ鿩 ����

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
 
------------------------------------ �� 1
SELECT t2.cdate ����, t2.amt �ݾ�, t1.crate ȯ��, t2.amt*t1.crate ȯȭ�ݾ�
  FROM (SELECT rownum rno, cdate, amt, crate FROM test02) t1
       ,(SELECT rownum rno, cdate, amt, crate FROM test02) t2
 WHERE t1.rno = t2.rno-1
 
 --------------------------------------------------------- �� 2
        
 SELECT t1.cdate ����, t1.amt �ݾ�, t2.crate ȯ��, t1.amt*t2.crate ȯȭ�ݾ�
  FROM (SELECT rownum rno, cdate, amt, crate FROM test02) t1
       ,(SELECT rownum rno, cdate, amt, crate FROM test02) t2
 WHERE t2.rno = t1.rno-1