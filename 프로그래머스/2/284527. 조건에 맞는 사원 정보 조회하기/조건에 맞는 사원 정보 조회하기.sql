select 
sum(g.score) as score,
e.EMP_NO,
e.EMP_name,
e.position,
e.email
from HR_EMPLOYEES e join HR_GRADE g
on e.EMP_NO = g.EMP_NO
group by e.EMP_NO
order by score desc
limit 1;