-- 코드를 입력하세요
select id, name, host_id
from PLACES
where host_id in (
SELECT HOST_ID
from PLACES
group by HOST_ID
having count(*) > 1
)
order by id;