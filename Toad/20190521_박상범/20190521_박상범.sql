SELECT *
  FROM t_giftorder
  
SELECT * 
  FROM t_giftorder, (SELECT * FROM t_giftorder)
  
SELECT * 
  FROM t_giftorder t1, (SELECT * FROM t_giftorder) t2
 WHERE t1.name_vc = t2.name_vc

------------------ ���� �ϳ� �÷��� �غ��� ������� �����غ���
SELECT *
  FROM (SELECT rownum rno, name_vc, quantity_nu FROM t_giftorder) t1
      ,(SELECT rownum rno2, name_vc, quantity_nu FROM t_giftorder) t2

SELECT *
  FROM (SELECT rownum rno, name_vc, quantity_nu FROM t_giftorder) t1
      ,(SELECT rownum rno2, name_vc, quantity_nu FROM t_giftorder) t2
 WHERE t1.rno=t2.rno2
 
SELECT *
  FROM (SELECT rownum rno, name_vc, quantity_nu FROM t_giftorder) t1
      ,(SELECT rownum rno2, name_vc, quantity_nu FROM t_giftorder) t2
 WHERE t1.rno+2=t2.rno2

SELECT t1.name_vc, t2.quantity_nu||','||t1.quantity_nu VALUE
  FROM (SELECT rownum rno, name_vc, quantity_nu FROM t_giftorder) t1
      ,(SELECT rownum rno2, name_vc, quantity_nu FROM t_giftorder) t2
 WHERE t1.rno+2=t2.rno2
 
 
-------------�ٸ� ����� ������ ?

SELECT *
  FROM t_giftorder t1, (SELECT * FROM t_giftorder) t2
  
SELECT *
  FROM t_giftorder t1, (SELECT * FROM t_giftorder) t2
 WHERE t1.num_nu = t2.num_nu

SELECT t1.name_vc
  FROM (SELECT * FROM t_giftorder) t1, (SELECT * FROM t_giftorder) t2
 WHERE t1.num_nu = t2.num_nu
GROUP BY t1.name_vc ----------�׷��Լ��� ����� �� ��� �Ұ��غ���

-------------------