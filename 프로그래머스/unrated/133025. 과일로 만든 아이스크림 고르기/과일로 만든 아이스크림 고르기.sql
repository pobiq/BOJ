-- 코드를 입력하세요
SELECT FLAVOR
from FIRST_HALF 
natural join ICECREAM_INFO
where TOTAL_ORDER >= 3000
and INGREDIENT_TYPE = 'fruit_based'
order by TOTAL_ORDER desc