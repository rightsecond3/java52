SELECT *
  FROM t_orderbasket,
       (
        SELECT rownum rno FROM t_orderbasket WHERE rownum<5
        )
        
SELECT DECODE(rno, 1, indate_vc
                  ,2, indate_vc
                  ,3, indate_vc ||'계'
                  ,4, '총계')
  FROM t_orderbasket,
       (
        SELECT rownum rno FROM t_orderbasket WHERE rownum<5
        )

SELECT DECODE(rno, 1, indate_vc
                  ,2, indate_vc
                  ,3, indate_vc ||'계'
                  ,4, '총계')
      ,DECODE(rno, 1, gubun_vc
                  ,2, gubun_vc || '계'
                  ,3,  null
                  ,4, null)
      ,DECODE(rno, 1, name_vc)
  FROM t_orderbasket,
       (
        SELECT rownum rno FROM t_orderbasket WHERE rownum<4
        )
        
SELECT DECODE(rno, 1, indate_vc
                  ,2, indate_vc
                  ,3, indate_vc ||'계'
                  ,4, '총계') 판매날짜
      ,DECODE(rno, 1, gubun_vc
                  ,2, gubun_vc || '계'
                  ,3,  null
                  ,4, null) 물품구분
      ,DECODE(rno, 1, name_vc) 물품명
      ,qty_nu 판매개수, qty_nu*price_nu 판매가격
  FROM t_orderbasket,
       (
        SELECT rownum rno FROM t_orderbasket WHERE rownum<4
        )
        
        
SELECT DECODE(rno, 1, indate_vc
                  ,2, indate_vc
                  ,3, indate_vc ||'계'
                  ,4, '종합') 판매날짜
      ,DECODE(rno, 1, gubun_vc
                  ,2, gubun_vc || '계'
                  ,3,  null
                  ,4, null) 물품구분
      ,DECODE(rno, 1, name_vc) 물품명
      ,SUM(qty_nu)||' 개' 판매개수
      ,TO_CHAR(SUM(qty_nu*price_nu), '999,999,999')||'원' 판매가격
  FROM t_orderbasket,
       (
        SELECT rownum rno FROM dept WHERE rownum<5
        )
GROUP BY  DECODE(rno, 1, indate_vc
                  ,2, indate_vc
                  ,3, indate_vc ||'계'
                  ,4, '종합')
         ,DECODE(rno, 1, gubun_vc
                  ,2, gubun_vc || '계'
                  ,3,  null
                  ,4, null)
         ,DECODE(rno, 1, name_vc)
ORDER BY DECODE(rno, 1, indate_vc
                  ,2, indate_vc
                  ,3, indate_vc ||'계'
                  ,4, '종합')