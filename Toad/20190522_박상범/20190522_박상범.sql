SELECT * FROM t_orderbasket

------------��¥, �Ұ�, �Ѱ踦 �������̺��� �ο���� �̿��� �����̺� ǥ���غ���
SELECT *
  FROM t_orderbasket
      ,(SELECT rownum rno FROM t_orderbasket WHERE rownum<4)
      
SELECT DECODE(rno, 1, indate_vc
                  , 2, '�Ұ�'
                  , 3, '�Ѱ�')
  FROM t_orderbasket
      ,(SELECT rownum rno FROM t_orderbasket WHERE rownum<4)
      
SELECT DECODE(rno, 1, indate_vc
                  , 2, '�Ұ�'
                  , 3, '�Ѱ�')
      , gubun_vc, qty_nu, (qty_nu*price_nu)
  FROM t_orderbasket
      ,(SELECT rownum rno FROM t_orderbasket WHERE rownum<4)
     
-------------- �׷���̷� �����غ� - ���� : �Ѱ迡�� ��ǰ������ ���� �ȵ�
SELECT DECODE(rno, 1, indate_vc
                  , 2, '�Ұ�'
                  , 3, '�Ѱ�') �Ǹų�¥
      , gubun_vc ��ǰ����, sum(qty_nu) �ǸŰ���, sum((qty_nu*price_nu)) �ǸŰ���
  FROM t_orderbasket
      ,(SELECT rownum rno FROM t_orderbasket WHERE rownum<4)
GROUP BY DECODE(rno, 1, indate_vc
                  , 2, '�Ұ�'
                  , 3, '�Ѱ�'), gubun_vc
ORDER BY DECODE(rno, 1, indate_vc
                  , 2, '�Ұ�'
                  , 3, '�Ѱ�') ASC
              
-----�Ѱ谪�� ���� �������� gubun_vc�� 2�� ��������!

SELECT DECODE(rno, 1, indate_vc
                  , 2, '�Ұ�'
                  , 3, '�Ѱ�') �Ǹų�¥
      ,DECODE(rno, 1, gubun_vc
                  ,2, gubun_vc||'��'
                  ,3, null) ��ǰ����
      , SUM(qty_nu)||'��' �ǸŰ���, SUM((qty_nu*price_nu))||' ��' �ǸŰ���
  FROM t_orderbasket
      ,(SELECT rownum rno FROM t_orderbasket WHERE rownum<4)
GROUP BY DECODE(rno, 1, indate_vc
                  , 2, '�Ұ�'
                  , 3, '�Ѱ�')
        ,DECODE(rno, 1, gubun_vc
                  ,2, gubun_vc||'��'
                  ,3, null)       
ORDER BY DECODE(rno, 1, indate_vc
                  , 2, '�Ұ�'
                  , 3, '�Ѱ�')
        ,DECODE(rno, 1, gubun_vc
                  ,2, gubun_vc||'��'
                  ,3, null)