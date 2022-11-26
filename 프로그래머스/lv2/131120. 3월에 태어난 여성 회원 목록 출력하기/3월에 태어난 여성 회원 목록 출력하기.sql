-- 코드를 입력하세요
SELECT MEMBER_ID, MEMBER_NAME, GENDER, DATE_FORMAT(DATE_OF_BIRTH, '%Y-%m-%d') as DATE_OF_BIRTH
from MEMBER_PROFILE
where substr(DATE_OF_BIRTH, 6, 2) = '03'
and tlno is not null
and GENDER = 'W'
order by MEMBER_ID asc;
