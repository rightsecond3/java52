-------------------1번
SELECT emp_name
  FROM temp
 WHERE hobby IS NOT NULL;

--인라인뷰로 완성 
SELECT emp_name
  FROM (SELECT emp_name, hobby FROM temp)
 WHERE hobby IS NOT NULL

--------------------2번
SELECT emp_name
  FROM temp
WHERE NVL(hobby, '등산') = '등산'

-----인라인뷰로 완성
SELECT emp_name
  FROM (
        SELECT emp_name, hobby
          FROM temp
        )
WHERE NVL(hobby, '등산') = '등산'

--인덱스가 있는 컬럼일지라도 조건절에서 가공할 경우 테이블 풀 스캔을 한다.
SELECT ename FROM emp WHERE NVL(empno,0)=7566

--------------
-----------------3번
SELECT deptno
  FROM emp
 WHERE ename='SMITH'

SELECT ename, hiredate
  FROM emp
 WHERE deptno = (
                  SELECT deptno
                    FROM emp
                   WHERE ename='SMITH'
                 )

--인라인뷰로 완성  
SELECT ename, hiredate
  FROM (SELECT ename,hiredate, deptno FROM emp)
 WHERE deptno = (
                  SELECT deptno
                    FROM emp
                   WHERE ename='SMITH'
                 )
 
----------------
----------------4번
-----4_1.LIKE 연산자 이용
SELECT empno, ename
  FROM emp
 WHERE hiredate LIKE '1982'||'%' --LIKE 연산자 사용 불가.. 타입문제인가

-------DATE 타입은 앞의 년도 두개가 생략됨, 이 경우 2082년도 올 수 있으니 바꾸자
SELECT empno, ename
  FROM emp
 WHERE hiredate LIKE '82'||'%'

--자바에서 연동할 때에도 쓰일 수 있으니 파이프 연산자로 %연산자는  따로 빼는것이 좋다
SELECT empno, ename
  FROM emp
 WHERE TO_CHAR(hiredate, 'YYYY') LIKE '1982'||'%'

------4_2. SUBSTR함수 사용
-----앞의 년도 두개가 생략되서 짤림, hiredate는 date타입
SELECT SUBSTR(hiredate,1,2)
  FROM emp

SELECT empno, ename
  FROM emp
 WHERE SUBSTR(hiredate, 1, 2) = '82'

---TO_CHAR를 이용해서 형식을 바꿔줌
SELECT SUBSTR(TO_CHAR(hiredate,'YYYY,MM,DD'),1,4) FROM emp

SELECT empno, ename
  FROM emp
 WHERE SUBSTR(TO_CHAR(hiredate,'YYYY,MM,DD'),1,4) = '1982'

-----4.3 BETWEEN 함수 사용
--자동 형전환을 해준다.
SELECT empno, ename
  FROM emp
 WHERE hiredate BETWEEN '1982-01-01' AND '1982-12-31'

SELECT empno, ename
  FROM emp
 WHERE TO_CHAR(hiredate, 'YYYY-MM-DD')
       BETWEEN '1982-01-01' AND '1982-12-31'
 
------------
---------------5번
SELECT ROUND(AVG(sal),2)
  FROM emp
 WHERE sal>=2000

------------인라인뷰로 완성
SELECT ROUND(AVG(sal),2)
  FROM (
        SELECT sal
          FROM emp
        )
 WHERE sal>=2000
 
--------------6번
1.파싱(문법체크)
2.dbms가 실행계획을 세움
3.실행계획을 옵티마이저에게 넘긴다.
4.OPEN - CURSOR -FETCH

---------------
--------------7번

SELECT * FROM t_giftpoint, t_giftmem

SELECT point_nu
  FROM t_giftpoint
 WHERE name_vc = '과일바구니'
 
-------
SELECT GM.name_vc 명단, GM.point_nu 보유포인트, GP.point_nu 상품포인트
  FROM t_giftmem GM
      ,(
        SELECT point_nu
          FROM t_giftpoint
         WHERE name_vc = '과일바구니'
        ) GP
 WHERE GM.point_nu >= (SELECT GP.point_nu
                          FROM t_giftpoint
                         WHERE name_vc = '과일바구니')
                         
---------인라인뷰로 완성
SELECT GM.name_vc 명단, GM.point_nu 보유포인트, GP.point_nu 상품포인트
  FROM t_giftmem GM
      ,(
        SELECT point_nu
          FROM (
                SELECT point_nu, name_vc
                  FROM t_giftpoint
                )
         WHERE name_vc = '과일바구니'
        ) GP
 WHERE GM.point_nu >= (SELECT GP.point_nu
                          FROM (
                                SELECT point_nu, name_vc
                                  FROM t_giftpoint
                                )
                         WHERE name_vc = '과일바구니')
                         
------------코스트가 더 적은 코드
SELECT GM.name_vc, GM.point_nu, GP.point_nu
  FROM t_giftmem GM, t_giftpoint GP
 WHERE GM.point_nu>GP.point_nu
   AND GP.name_vc = '과일바구니'
   
-----------------------
사원 50,000,000건
부서 100건
사원을 먼저 읽고 부서를 읽는 것이 효율적
사원의 deptno에서 해당 rowid를 찾고
부서 집합의 부서번호에는 인덱스가 있기 때문에
인덱스로 접근하면 5천만번만 읽으면 된다.
반대의 경우에는 부서번호를 인덱스로 먼저 접근하고 5천만건을 각각 다 비교해야된다.

SELECT rowid rid, ename FROM emp
WHERE rowid='AAARE8AAEAAAACTAAA'

------------------
-----------------------8번.
SELECT dept.dname
  FROM emp, dept
 WHERE emp.deptno = dept.deptno
   AND emp.ename='ALLEN'
   


-----------인라인뷰
SELECT dname
  FROM (
        SELECT deptno, ename
          FROM emp
        ) emp
      ,(
        SELECT deptno, dname
          FROM dept
       ) dept
 WHERE emp.deptno = dept.deptno
   AND ename='ALLEN'

-----------------
---------------------9번
SELECT dept.deptno, AVG(SAL) 급여평균
  FROM emp, dept
 WHERE emp.deptno=dept.deptno
GROUP BY dept.deptno

--------
SELECT A.부서번호, 급여평균
  FROM (
       SELECT dept.deptno 부서번호, AVG(SAL) 급여평균
         FROM emp, dept
        WHERE emp.deptno=dept.deptno
       GROUP BY dept.deptno
        ) A
 WHERE 급여평균>=2000
 
-------인라인뷰
SELECT A.부서번호, 급여평균
  FROM (
       SELECT dept.deptno 부서번호, AVG(SAL) 급여평균
         FROM (SELECT deptno, sal
                 FROM emp) emp
             ,(SELECT deptno
                 FROM dept) dept
        WHERE emp.deptno=dept.deptno
       GROUP BY dept.deptno
        ) A
 WHERE 급여평균>=2000
 
-----------HAVING절을 사용해야한다.
SELECT dept.deptno, AVG(emp.sal)
  FROM emp, dept
 WHERE emp.deptno=dept.deptno
GROUP BY dept.deptno
HAVING AVG(emp.sal)>=2000

----------------
-------------------10번
SELECT DECODE(job, 'MANAGER', SAL)
      ,DECODE(job, 'ANALYST', SAL)
      ,DECODE(job, 'MANAGER', NULL
                 , 'ANALYST', NULL, sal)
  FROM emp
  
------------
SELECT SUM(DECODE(job, 'MANAGER', SAL)) "MANAGER 급여합"
      ,SUM(DECODE(job, 'ANALYST', SAL)) "ANALYST 급여합"
      ,SUM(DECODE(job, 'MANAGER', NULL
                     , 'ANALYST', NULL, sal)) "나머지 급여합"
  FROM emp
  
----------인라인뷰로 완성
SELECT SUM(DECODE(job, 'MANAGER', SAL)) "MANAGER 급여합"
      ,SUM(DECODE(job, 'ANALYST', SAL)) "ANALYST 급여합"
      ,SUM(DECODE(job, 'MANAGER', NULL
                     , 'ANALYST', NULL, sal)) "나머지 급여합"
  FROM ( 
        SELECT job, sal
          FROM emp
        )
        
-------------
----------------11번
-------------------CASE WHEN 구문 사용
SELECT lec_id
      ,CASE WHEN lec_time>lec_point THEN '실험 과목'
            WHEN lec_time<lec_point THEN '기타 과목'
            WHEN lec_time=lec_point THEN '일반 과목'
       END AS 과목
  FROM lecture
  
----------------DECODE사용 SIGN
SELECT lec_id,
      DECODE(SIGN(lec_time-lec_point),1, '실험 과목'
                                     ,-1, '기타 과목'
                                     ,0, '일반 과목'  ) AS 과목
  FROM lecture
  
-------------
-----------------12번
SELECT DECODE(A, B, DECODE(C, D, 'T', 'F'), 'F2')
 FROM dual

-----잡이 클락이면서 사원번호가 7369이면 T, 잡이 클락이면서 사원번호가 7369가 아니면 F, 둘다 해당하지 않을때 F2출력
SELECT ename, empno, job
      ,DECODE(job, 'CLERK', DECODE(empno, 7369, 'T', 'F'), 'F2')
 FROM emp

로그인 처리하는 프로시저를 작성해 보시오.

아이디가 존재하지 않으면 -1
비번이 일치하지 않으면 0
아이디와 비번이 모두 일치하면 1