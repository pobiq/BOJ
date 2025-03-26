select count(id) as FISH_COUNT, n.fish_name
from FISH_INFO i inner join FISH_NAME_INFO n
on i.fish_type = n.fish_type
group by n.fish_name
order by FISH_COUNT desc;