select count(id) as FISH_COUNT, MONTH(time) as MONTH
from fish_info
group by MONTH
order by MONTH;