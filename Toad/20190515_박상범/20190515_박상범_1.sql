5��15�� ����Ʈ
Temp���̺��� �̿��Ͽ� �Ʒ��� ���� ��µǵ��� SQL���� �ۼ��Ͻÿ�

SELECT *
    FROM temp

SELECT *
 FROM temp, (SELECT rownum rno FROM temp)
 
 
����2
----------------

SELECT *
FROM emp, dept
WHERE emp.deptno=dept.deptno
 
 -----------------------
 
SELECT dept.dname
  from emp,dept 
 WHERE emp.deptno=dept.deptno
 GROUP BY dept.dname
 
 --------------
 
SELECT dept.dname,
       DECODE(emp.job, 'CLERK', emp.sal, null) as CLERK,
       DECODE(emp.job, 'MANAGER', emp.sal, null) as MANAGER,
       DECODE(emp.job, 'CLERK', null
                      , 'MANAGER', null
                                        ,sal) as ETC
  FROM emp ,dept  
 WHERE emp.deptno=dept.deptno --�ΰ����� ���� �ְ����

------------------------------------------
SELECT dept.dname,i_dept.CLERK, i_dept.MANAGER, i_dept.ETC
  FROM (SELECT DECODE(emp.job, 'CLERK', emp.sal, null) as CLERK,
               DECODE(emp.job, 'MANAGER', emp.sal, null) as MANAGER,
               DECODE(emp.job, 'CLERK', null
                                      , 'MANAGER', null
                                                        ,sal) as ETC
                     FROM emp, dept
                    WHERE emp.deptno=dept.deptno ) i_dept, dept, emp
 WHERE emp.deptno=dept.deptno
  ---------------------------------�ο찡 �ʹ� ���� ���� ������ ���� 

 SELECT 
       sum(DECODE(emp.job, 'CLERK', emp.sal, null)) as CLERK,
       sum(DECODE(emp.job, 'MANAGER', emp.sal, null)) as MANAGER,
       sum(DECODE(emp.job, 'CLERK', null
                      , 'MANAGER', null
                                        ,sal)) as a_sm
  FROM emp ,dept  
 WHERE emp.deptno=dept.deptno
  --------------------- �Ѱ谡 ���� 
 -----------------------------------1�� �ذ� max�� �ᵵ �ΰ��� ����� ���ϴϱ� ������

 SELECT dept.dname,
       max(DECODE(emp.job, 'CLERK', emp.sal, null)) as CLERK,
       max(DECODE(emp.job, 'MANAGER', emp.sal, null)) as MANAGER,
       max(DECODE(emp.job, 'CLERK', null
                      , 'MANAGER', null
                                        ,sal)) as ETC
  FROM emp ,dept  
 WHERE emp.deptno=dept.deptno
 GROUP BY dept.dname
 ----------------------------------- dept_sal�� �߰��غ���
  
 SELECT dept.dname,
       max(DECODE(emp.job, 'CLERK', emp.sal, null)) as CLERK,
       max(DECODE(emp.job, 'MANAGER', emp.sal, null)) as MANAGER,
       max(DECODE(emp.job, 'CLERK', null
                      , 'MANAGER', null
                                        ,sal)) as ETC,
       sum(DECODE(emp.job,'CLERK',sal,null
                          ,'MANAGER',sal,null
                          ,'ETC', sal, null)
                                              )
  FROM emp ,dept  
 WHERE emp.deptno=dept.deptno
 GROUP BY dept.dname
 
  -----------------------------------------
 SELECT dept.dname,
       DECODE(emp.job, 'CLERK', emp.sal) as CLERK,
       DECODE(emp.job, 'MANAGER', emp.sal) as MANAGER,
       DECODE(emp.job, 'CLERK', null
                      , 'MANAGER', null
                                        ,sal) as ETC,
       DECODE(emp.deptno, 10, sal
                         , 20, sal
                         , 30, sal)
  FROM emp ,dept  
 WHERE emp.deptno=dept.deptno
 
 ----------------------------dept_sal�� ����غ��� ,sum���� ����� �Ѿ��� ���� ���´�


SELECT dept.dname,
       MAX(DECODE(emp.job, 'CLERK', emp.sal)) as CLERK,
       MAX(DECODE(emp.job, 'MANAGER', emp.sal)) as MANAGER,
       MAX(DECODE(emp.job, 'CLERK', 0
                         , 'MANAGER', null
                                          ,sal)) as ETC,
       SUM(DECODE(emp.deptno, 10, sal
                            , 20, sal
                            , 30, sal)) as DEPT_SAL
  FROM emp ,dept  
 WHERE emp.deptno=dept.deptno
 GROUP BY dept.dname
 
 
------------------------------------------------------------
 SELECT dept.dname,
       sum(DECODE(emp.job, 'CLERK', emp.sal)) as CLERK,
       sum(DECODE(emp.job, 'MANAGER', emp.sal)) as MANAGER,
       sum(DECODE(emp.job, 'CLERK', 0
                         , 'MANAGER', 0
                                        ,sal)) as ETC,
       SUM(DECODE(emp.deptno, 10, sal
                             , 20, sal
                             , 30, sal)) as DEPT_SAL
  FROM emp ,dept   
 WHERE emp.deptno=dept.deptno
 GROUP BY dept.dname
UNION ALL
SELECT '�Ѱ�',
       sum(DECODE(emp.job, 'CLERK', emp.sal)) as CLERK,
       sum(DECODE(emp.job, 'MANAGER', emp.sal)) as MANAGER,
       sum(DECODE(emp.job, 'CLERK', 0
                         , 'MANAGER', 0
                                        ,sal)) as ETC,
       SUM(DECODE(emp.deptno, 10, sal
                             , 20, sal
                             , 30, sal)) as DEPT_SAL
  FROM emp
