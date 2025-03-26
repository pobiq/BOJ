select 
    count(id) as fish_count,
    max(length) as MAX_LENGTH,
    fish_type
from fish_info
group by fish_type
having avg(IFNULL(length, 10)) >= 33
order by fish_type