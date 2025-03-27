select CATEGORY, price as MAX_PRICE, product_name
from (
    SELECT category, price, product_name,
        rank() over (partition by category order by price desc) as ranking
    from FOOD_PRODUCT
    where category in ('과자', '국', '김치', '식용유')
) as food_ranking
where ranking = 1
order by MAX_PRICE desc;