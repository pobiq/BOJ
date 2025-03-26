select d.id, d.email, d.first_name, d.last_name
from DEVELOPERS as d
where skill_code & (select code from SKILLCODES where name = 'Python') = 256
or skill_code & (select code from SKILLCODES where name = 'C#') = 1024
order by d.id;