SELECT *
  FROM t_giftorder
  
SELECT * 
  FROM t_giftorder, (SELECT * FROM t_giftorder)
  
SELECT * 
  FROM t_giftorder t1, (SELECT * FROM t_giftorder) t2
 WHERE t1.name_vc = t2.name_vc

------------------ 행을 하나 올려서 해보는 방식으로 접근해보자
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
 
 
-------------다른 방법은 없을까 ?

SELECT *
  FROM t_giftorder t1, (SELECT * FROM t_giftorder) t2
  
SELECT *
  FROM t_giftorder t1, (SELECT * FROM t_giftorder) t2
 WHERE t1.num_nu = t2.num_nu

SELECT t1.name_vc
  FROM (SELECT * FROM t_giftorder) t1, (SELECT * FROM t_giftorder) t2
 WHERE t1.num_nu = t2.num_nu
GROUP BY t1.name_vc ----------그룹함수를 사용할 수 없어서 불가해보임

-------------------