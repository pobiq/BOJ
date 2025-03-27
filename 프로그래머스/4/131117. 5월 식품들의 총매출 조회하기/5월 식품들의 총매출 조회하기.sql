SELECT p.product_id, p.product_name, sum(o.amount*p.price) as TOTAL_SALES
from FOOD_PRODUCT p inner join FOOD_ORDER o
on p.product_id = o.product_id
where o.PRODUCE_DATE like '2022-05%'
group by p.product_id
order by TOTAL_SALES desc, p.product_id;