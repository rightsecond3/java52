SELECT *
  FROM t_orderbasket,
       (
        SELECT rownum rno FROM t_orderbasket WHERE rownum<5
        )
        
SELECT DECODE(rno, 1, indate_vc
                  ,2, indate_vc
                  ,3, indate_vc ||'��'
                  ,4, '�Ѱ�')
  FROM t_orderbasket,
       (
        SELECT rownum rno FROM t_orderbasket WHERE rownum<5
        )

SELECT DECODE(rno, 1, indate_vc
                  ,2, indate_vc
                  ,3, indate_vc ||'��'
                  ,4, '�Ѱ�')
      ,DECODE(rno, 1, gubun_vc
                  ,2, gubun_vc || '��'
                  ,3,  null
                  ,4, null)
      ,DECODE(rno, 1, name_vc)
  FROM t_orderbasket,
       (
        SELECT rownum rno FROM t_orderbasket WHERE rownum<4
        )
        
SELECT DECODE(rno, 1, indate_vc
                  ,2, indate_vc
                  ,3, indate_vc ||'��'
                  ,4, '�Ѱ�') �Ǹų�¥
      ,DECODE(rno, 1, gubun_vc
                  ,2, gubun_vc || '��'
                  ,3,  null
                  ,4, null) ��ǰ����
      ,DECODE(rno, 1, name_vc) ��ǰ��
      ,qty_nu �ǸŰ���, qty_nu*price_nu �ǸŰ���
  FROM t_orderbasket,
       (
        SELECT rownum rno FROM t_orderbasket WHERE rownum<4
        )
        
        
SELECT DECODE(rno, 1, indate_vc
                  ,2, indate_vc
                  ,3, indate_vc ||'��'
                  ,4, '����') �Ǹų�¥
      ,DECODE(rno, 1, gubun_vc
                  ,2, gubun_vc || '��'
                  ,3,  null
                  ,4, null) ��ǰ����
      ,DECODE(rno, 1, name_vc) ��ǰ��
      ,SUM(qty_nu)||' ��' �ǸŰ���
      ,TO_CHAR(SUM(qty_nu*price_nu), '999,999,999')||'��' �ǸŰ���
  FROM t_orderbasket,
       (
        SELECT rownum rno FROM dept WHERE rownum<5
        )
GROUP BY  DECODE(rno, 1, indate_vc
                  ,2, indate_vc
                  ,3, indate_vc ||'��'
                  ,4, '����')
         ,DECODE(rno, 1, gubun_vc
                  ,2, gubun_vc || '��'
                  ,3,  null
                  ,4, null)
         ,DECODE(rno, 1, name_vc)
ORDER BY DECODE(rno, 1, indate_vc
                  ,2, indate_vc
                  ,3, indate_vc ||'��'
                  ,4, '����')