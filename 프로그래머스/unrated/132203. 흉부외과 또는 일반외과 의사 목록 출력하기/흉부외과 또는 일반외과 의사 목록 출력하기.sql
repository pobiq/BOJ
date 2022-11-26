-- 코드를 입력하세요
SELECT dr_name, dr_id, mcdp_cd,  DATE_FORMAT(hire_ymd, '%Y-%m-%d') AS HIRE_YMD
from doctor
where MCDP_CD = 'CS' or MCDP_CD = 'GS'
order by HIRE_YMD desc, dr_name