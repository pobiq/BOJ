-- 코드를 입력하세요
SELECT BOOK.CATEGORY, sum(BOOK_SALES.sales) as TOTAL_SALES
from BOOK
    inner join BOOK_SALES
    on BOOK.BOOK_ID = BOOK_SALES.BOOK_ID
where BOOK_SALES.SALES_DATE like '2022-01%'
group by BOOK.CATEGORY
order by 1;


/*
select BOOK.category, BOOK_SALES.sales
from BOOK
    inner join BOOK_SALES
    on BOOK.BOOK_ID = BOOK_SALES.BOOK_ID
where BOOK_SALES.SALES_DATE like '2022-01%';
*/
