-- 코드를 입력하세요
SELECT INGREDIENT_TYPE, sum(TOTAL_ORDER) as TOTAL_ORDER
from FIRST_HALF
natural join ICECREAM_INFO
group by INGREDIENT_TYPE
order by TOTAL_ORDER asc;