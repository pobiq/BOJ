-- 코드를 입력하세요

select sub.flavor
from 
(
SELECT a.flavor, a.total_order + b.total_order as total_order
from FIRST_HALF a left outer join
    (
    SELECT flavor, sum(total_order) as total_order
    from JULY
    group by flavor
    ) b 
on a.FLAVOR = b.FLAVOR
order by total_order desc
LIMIT 3
) sub;


