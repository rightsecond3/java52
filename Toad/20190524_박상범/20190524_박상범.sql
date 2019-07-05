SELECT DECODE(rno, 1, dname
                  , 2, 'ÃÑ°è')
      ,DECODE(e.job, 'CLERK', SAL)
      ,DECODE(e.job, 'MANAGER', SAL)
      ,DECODE(e.job, 'CLERK', NULL
                   , 'MANAGER', NULL, SAL)                   
  FROM emp e, dept d , (SELECT rownum rno FROM dept WHERE rownum<3)
 WHERE e.deptno=d.deptno
ORDER BY DECODE(rno, 1, dname
                  , 2, 'ÃÑ°è')
                  
--------------------
SELECT DECODE(rno, 1, d.dname
                  , 2, 'ÃÑ°è') DNAME 
      ,SUM(DECODE(e.job, 'CLERK', e.SAL)) CLERK
      ,SUM(DECODE(e.job, 'MANAGER', e.SAL)) MANAGER
      ,SUM(DECODE(e.job, 'CLERK', NULL
                   , 'MANAGER', NULL, e.SAL)) ETC
      ,SUM(e.sal) DEPT_SAL
  FROM emp e, dept d , (SELECT rownum rno FROM dept WHERE rownum<3)
 WHERE e.deptno=d.deptno
GROUP BY DECODE(rno, 1, d.dname
                  , 2, 'ÃÑ°è')
ORDER BY DECODE(rno, 1, d.dname
                  , 2, 'ÃÑ°è')
