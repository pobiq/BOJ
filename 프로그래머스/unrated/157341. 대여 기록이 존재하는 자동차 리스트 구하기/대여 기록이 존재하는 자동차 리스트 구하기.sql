-- 코드를 입력하세요
SELECT distinct(sub.car_id)
from CAR_RENTAL_COMPANY_CAR main
inner join CAR_RENTAL_COMPANY_RENTAL_HISTORY sub
on main.CAR_ID = sub.CAR_ID
where main.CAR_TYPE = '세단'
and sub.start_date like '2022-10%'
order by 1 desc;