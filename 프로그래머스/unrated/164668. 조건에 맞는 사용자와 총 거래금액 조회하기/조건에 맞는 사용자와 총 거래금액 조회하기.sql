-- 코드를 입력하세요
SELECT b.WRITER_ID, u.NICKNAME, sum(b.price) TOTAL_SALES
from USED_GOODS_BOARD b
inner join USED_GOODS_USER u
on b.WRITER_ID = u.USER_ID
where b.STATUS = 'DONE'
group by b.WRITER_ID
having sum(b.price) >= 700000
order by TOTAL_SALES;
