SELECT rno, ceil(rno/5), emp_id, emp_name
  FROM (SELECT rownum rno, emp_id, emp_name 
         FROM temp) 
         
--------------------------------------------
SELECT ceil(rno/5) RNO,
       MAX(DECODE(MOD(rno,5), 1,emp_id)) ID1,
       MAX(DECODE(MOD(rno,5), 1,emp_name)) NAME1,
       MAX(DECODE(MOD(rno,5), 2,emp_id)) ID2,
       MAX(DECODE(MOD(rno,5), 2,emp_name)) NAME2, 
       MAX(DECODE(MOD(rno,5), 3,emp_id)) ID3,
       MAX(DECODE(MOD(rno,5), 3,emp_name)) NAME3,
       MAX(DECODE(MOD(rno,5), 4,emp_id)) ID4,
       MAX(DECODE(MOD(rno,5), 4,emp_name)) NAMES4,
       MAX(DECODE(MOD(rno,5), 0,emp_id)) ID5,
       MAX(DECODE(MOD(rno,5), 0,emp_name)) NAME5
  FROM (SELECT rownum rno, emp_id, emp_name 
         FROM temp)        
 GROUP BY ceil(rno/5)
 ORDER BY ceil(rno/5)
         
         
         
         
         
         
--------------------------------------------
SELECT rno, ceil(rno/3), gubun,
       DECODE(MOD(rno,3),1,gubun), DECODE(MOD(rno,3),2,gubun), DECODE(MOD(rno,3),0,gubun)
  FROM (SELECT rownum rno, gubun 
         FROM sam_tab02)