5월15일 레포트
Temp테이블을 이용하여 아래와 같이 출력되도록 SQL문을 작성하시오

SELECT *
    FROM temp

SELECT *
 FROM temp, (SELECT rownum rno FROM temp)
 
 
문제2
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
 WHERE emp.deptno=dept.deptno --널값들을 합쳐 주고싶음

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
  ---------------------------------로우가 너무 많이 나옴 완전한 오답 

 SELECT 
       sum(DECODE(emp.job, 'CLERK', emp.sal, null)) as CLERK,
       sum(DECODE(emp.job, 'MANAGER', emp.sal, null)) as MANAGER,
       sum(DECODE(emp.job, 'CLERK', null
                      , 'MANAGER', null
                                        ,sal)) as a_sm
  FROM emp ,dept  
 WHERE emp.deptno=dept.deptno
  --------------------- 총계가 나옴 
 -----------------------------------1차 해결 max를 써도 널값은 계산을 안하니까 합쳐짐

 SELECT dept.dname,
       max(DECODE(emp.job, 'CLERK', emp.sal, null)) as CLERK,
       max(DECODE(emp.job, 'MANAGER', emp.sal, null)) as MANAGER,
       max(DECODE(emp.job, 'CLERK', null
                      , 'MANAGER', null
                                        ,sal)) as ETC
  FROM emp ,dept  
 WHERE emp.deptno=dept.deptno
 GROUP BY dept.dname
 ----------------------------------- dept_sal을 추가해보자
  
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
 
 ----------------------------dept_sal을 출력해보자 ,sum으로 해줘야 총액의 합이 나온다


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
SELECT '총계',
       sum(DECODE(emp.job, 'CLERK', emp.sal)) as CLERK,
       sum(DECODE(emp.job, 'MANAGER', emp.sal)) as MANAGER,
       sum(DECODE(emp.job, 'CLERK', 0
                         , 'MANAGER', 0
                                        ,sal)) as ETC,
       SUM(DECODE(emp.deptno, 10, sal
                             , 20, sal
                             , 30, sal)) as DEPT_SAL
  FROM emp
