select count(*) as COUNT
from ECOLI_DATA
where RIGHT(CONV(GENOTYPE, 10, 2), 3) in (101, 100, 1);