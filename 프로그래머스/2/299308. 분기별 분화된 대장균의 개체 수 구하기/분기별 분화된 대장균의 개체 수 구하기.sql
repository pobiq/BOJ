select
case
    when MONTH(DIFFERENTIATION_DATE) between 1 and 3 then '1Q'
    when MONTH(DIFFERENTIATION_DATE) between 4 and 6 then '2Q'
    when MONTH(DIFFERENTIATION_DATE) between 7 and 9 then '3Q'
    else '4Q'
end as QUARTER,
count(id) as ECOLI_COUNT
from ECOLI_DATA
group by QUARTER
order by QUARTER;
