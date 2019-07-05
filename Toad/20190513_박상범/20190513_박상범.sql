문제1
영화티켓을 받을 수 있는 사람의 명단과 현재 가지고
있는 포인트, 영화티켓의 포인트 그리고 사용 후
잔여포인트를 출력하는 SQL문을 작성하시오.

A답안 (WHERE절 조건 두개)

SELECT t_giftmem.name_vc "받을 수 있는 명단"
    ,t_giftmem.point_nu "현포인트"
    ,t_giftpoint.point_nu "영화티켓 포인트"
    ,t_giftmem.point_nu-t_giftpoint.point_nu "잔여 포인트"
     FROM t_giftmem, t_giftpoint
  WHERE t_giftpoint.name_vc='영화티켓'
  AND t_giftmem.point_nu>=t_giftpoint.point_nu;  
  
B답안.(WHERE절 조건이 하나 줄어듬)

SELECT A.name_vc "티켓 수령가능자"
      ,A.point_nu "현포인트"
      ,B.point_nu "영화티켓 포인트"
      ,A.point_nu-B.point_nu "잔여포인트"
    FROM t_giftmem A, (SELECT point_nu FROM t_giftpoint WHERE name_vc='영화티켓') B
  WHERE A.point_nu>=B.point_nu;
