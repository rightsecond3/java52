-------------------1��
SELECT emp_name
  FROM temp
 WHERE hobby IS NOT NULL;

--�ζ��κ�� �ϼ� 
SELECT emp_name
  FROM (SELECT emp_name, hobby FROM temp)
 WHERE hobby IS NOT NULL

--------------------2��
SELECT emp_name
  FROM temp
WHERE NVL(hobby, '���') = '���'

-----�ζ��κ�� �ϼ�
SELECT emp_name
  FROM (
        SELECT emp_name, hobby
          FROM temp
        )
WHERE NVL(hobby, '���') = '���'

--�ε����� �ִ� �÷������� ���������� ������ ��� ���̺� Ǯ ��ĵ�� �Ѵ�.
SELECT ename FROM emp WHERE NVL(empno,0)=7566

--------------
-----------------3��
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

--�ζ��κ�� �ϼ�  
SELECT ename, hiredate
  FROM (SELECT ename,hiredate, deptno FROM emp)
 WHERE deptno = (
                  SELECT deptno
                    FROM emp
                   WHERE ename='SMITH'
                 )
 
----------------
----------------4��
-----4_1.LIKE ������ �̿�
SELECT empno, ename
  FROM emp
 WHERE hiredate LIKE '1982'||'%' --LIKE ������ ��� �Ұ�.. Ÿ�Թ����ΰ�

-------DATE Ÿ���� ���� �⵵ �ΰ��� ������, �� ��� 2082�⵵ �� �� ������ �ٲ���
SELECT empno, ename
  FROM emp
 WHERE hiredate LIKE '82'||'%'

--�ڹٿ��� ������ ������ ���� �� ������ ������ �����ڷ� %�����ڴ�  ���� ���°��� ����
SELECT empno, ename
  FROM emp
 WHERE TO_CHAR(hiredate, 'YYYY') LIKE '1982'||'%'

------4_2. SUBSTR�Լ� ���
-----���� �⵵ �ΰ��� �����Ǽ� ©��, hiredate�� dateŸ��
SELECT SUBSTR(hiredate,1,2)
  FROM emp

SELECT empno, ename
  FROM emp
 WHERE SUBSTR(hiredate, 1, 2) = '82'

---TO_CHAR�� �̿��ؼ� ������ �ٲ���
SELECT SUBSTR(TO_CHAR(hiredate,'YYYY,MM,DD'),1,4) FROM emp

SELECT empno, ename
  FROM emp
 WHERE SUBSTR(TO_CHAR(hiredate,'YYYY,MM,DD'),1,4) = '1982'

-----4.3 BETWEEN �Լ� ���
--�ڵ� ����ȯ�� ���ش�.
SELECT empno, ename
  FROM emp
 WHERE hiredate BETWEEN '1982-01-01' AND '1982-12-31'

SELECT empno, ename
  FROM emp
 WHERE TO_CHAR(hiredate, 'YYYY-MM-DD')
       BETWEEN '1982-01-01' AND '1982-12-31'
 
------------
---------------5��
SELECT ROUND(AVG(sal),2)
  FROM emp
 WHERE sal>=2000

------------�ζ��κ�� �ϼ�
SELECT ROUND(AVG(sal),2)
  FROM (
        SELECT sal
          FROM emp
        )
 WHERE sal>=2000
 
--------------6��
1.�Ľ�(����üũ)
2.dbms�� �����ȹ�� ����
3.�����ȹ�� ��Ƽ���������� �ѱ��.
4.OPEN - CURSOR -FETCH

---------------
--------------7��

SELECT * FROM t_giftpoint, t_giftmem

SELECT point_nu
  FROM t_giftpoint
 WHERE name_vc = '���Ϲٱ���'
 
-------
SELECT GM.name_vc ���, GM.point_nu ��������Ʈ, GP.point_nu ��ǰ����Ʈ
  FROM t_giftmem GM
      ,(
        SELECT point_nu
          FROM t_giftpoint
         WHERE name_vc = '���Ϲٱ���'
        ) GP
 WHERE GM.point_nu >= (SELECT GP.point_nu
                          FROM t_giftpoint
                         WHERE name_vc = '���Ϲٱ���')
                         
---------�ζ��κ�� �ϼ�
SELECT GM.name_vc ���, GM.point_nu ��������Ʈ, GP.point_nu ��ǰ����Ʈ
  FROM t_giftmem GM
      ,(
        SELECT point_nu
          FROM (
                SELECT point_nu, name_vc
                  FROM t_giftpoint
                )
         WHERE name_vc = '���Ϲٱ���'
        ) GP
 WHERE GM.point_nu >= (SELECT GP.point_nu
                          FROM (
                                SELECT point_nu, name_vc
                                  FROM t_giftpoint
                                )
                         WHERE name_vc = '���Ϲٱ���')
                         
------------�ڽ�Ʈ�� �� ���� �ڵ�
SELECT GM.name_vc, GM.point_nu, GP.point_nu
  FROM t_giftmem GM, t_giftpoint GP
 WHERE GM.point_nu>GP.point_nu
   AND GP.name_vc = '���Ϲٱ���'
   
-----------------------
��� 50,000,000��
�μ� 100��
����� ���� �а� �μ��� �д� ���� ȿ����
����� deptno���� �ش� rowid�� ã��
�μ� ������ �μ���ȣ���� �ε����� �ֱ� ������
�ε����� �����ϸ� 5õ������ ������ �ȴ�.
�ݴ��� ��쿡�� �μ���ȣ�� �ε����� ���� �����ϰ� 5õ������ ���� �� ���ؾߵȴ�.

SELECT rowid rid, ename FROM emp
WHERE rowid='AAARE8AAEAAAACTAAA'

------------------
-----------------------8��.
SELECT dept.dname
  FROM emp, dept
 WHERE emp.deptno = dept.deptno
   AND emp.ename='ALLEN'
   


-----------�ζ��κ�
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
---------------------9��
SELECT dept.deptno, AVG(SAL) �޿����
  FROM emp, dept
 WHERE emp.deptno=dept.deptno
GROUP BY dept.deptno

--------
SELECT A.�μ���ȣ, �޿����
  FROM (
       SELECT dept.deptno �μ���ȣ, AVG(SAL) �޿����
         FROM emp, dept
        WHERE emp.deptno=dept.deptno
       GROUP BY dept.deptno
        ) A
 WHERE �޿����>=2000
 
-------�ζ��κ�
SELECT A.�μ���ȣ, �޿����
  FROM (
       SELECT dept.deptno �μ���ȣ, AVG(SAL) �޿����
         FROM (SELECT deptno, sal
                 FROM emp) emp
             ,(SELECT deptno
                 FROM dept) dept
        WHERE emp.deptno=dept.deptno
       GROUP BY dept.deptno
        ) A
 WHERE �޿����>=2000
 
-----------HAVING���� ����ؾ��Ѵ�.
SELECT dept.deptno, AVG(emp.sal)
  FROM emp, dept
 WHERE emp.deptno=dept.deptno
GROUP BY dept.deptno
HAVING AVG(emp.sal)>=2000

----------------
-------------------10��
SELECT DECODE(job, 'MANAGER', SAL)
      ,DECODE(job, 'ANALYST', SAL)
      ,DECODE(job, 'MANAGER', NULL
                 , 'ANALYST', NULL, sal)
  FROM emp
  
------------
SELECT SUM(DECODE(job, 'MANAGER', SAL)) "MANAGER �޿���"
      ,SUM(DECODE(job, 'ANALYST', SAL)) "ANALYST �޿���"
      ,SUM(DECODE(job, 'MANAGER', NULL
                     , 'ANALYST', NULL, sal)) "������ �޿���"
  FROM emp
  
----------�ζ��κ�� �ϼ�
SELECT SUM(DECODE(job, 'MANAGER', SAL)) "MANAGER �޿���"
      ,SUM(DECODE(job, 'ANALYST', SAL)) "ANALYST �޿���"
      ,SUM(DECODE(job, 'MANAGER', NULL
                     , 'ANALYST', NULL, sal)) "������ �޿���"
  FROM ( 
        SELECT job, sal
          FROM emp
        )
        
-------------
----------------11��
-------------------CASE WHEN ���� ���
SELECT lec_id
      ,CASE WHEN lec_time>lec_point THEN '���� ����'
            WHEN lec_time<lec_point THEN '��Ÿ ����'
            WHEN lec_time=lec_point THEN '�Ϲ� ����'
       END AS ����
  FROM lecture
  
----------------DECODE��� SIGN
SELECT lec_id,
      DECODE(SIGN(lec_time-lec_point),1, '���� ����'
                                     ,-1, '��Ÿ ����'
                                     ,0, '�Ϲ� ����'  ) AS ����
  FROM lecture
  
-------------
-----------------12��
SELECT DECODE(A, B, DECODE(C, D, 'T', 'F'), 'F2')
 FROM dual

-----���� Ŭ���̸鼭 �����ȣ�� 7369�̸� T, ���� Ŭ���̸鼭 �����ȣ�� 7369�� �ƴϸ� F, �Ѵ� �ش����� ������ F2���
SELECT ename, empno, job
      ,DECODE(job, 'CLERK', DECODE(empno, 7369, 'T', 'F'), 'F2')
 FROM emp

�α��� ó���ϴ� ���ν����� �ۼ��� ���ÿ�.

���̵� �������� ������ -1
����� ��ġ���� ������ 0
���̵�� ����� ��� ��ġ�ϸ� 1