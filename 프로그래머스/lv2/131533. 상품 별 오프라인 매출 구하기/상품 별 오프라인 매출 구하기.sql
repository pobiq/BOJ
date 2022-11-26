-- 코드를 입력하세요
SELECT PRODUCT_CODE, PRICE * sum(SALES_AMOUNT) as SALES
from PRODUCT
natural join OFFLINE_SALE
group by PRODUCT_ID
order by SALES desc, PRODUCT_CODE asc;




