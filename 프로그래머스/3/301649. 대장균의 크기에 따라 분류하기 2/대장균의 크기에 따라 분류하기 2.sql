with ECOLI_RANK as (
    select 
        id,
        SIZE_OF_COLONY,
        rank() over (order by SIZE_OF_COLONY desc) as ranking
    from ECOLI_DATA
    order by SIZE_OF_COLONY desc
)

select 
    id,
    case
        when ranking <= count(*) over() / 4 then "CRITICAL"
        when ranking <= count(*) over() * 2 / 4 then "HIGH"
        when ranking <= count(*) over() * 3 / 4 then "MEDIUM"
        else "LOW"
    end as COLONY_NAME
from 
    ECOLI_RANK
order by 
    id asc;