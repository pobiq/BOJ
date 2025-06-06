WITH REVIEW_RANK AS (
    SELECT R.MEMBER_ID, DENSE_RANK() OVER(ORDER BY COUNT(R.MEMBER_ID) DESC) AS RANKING
    FROM REST_REVIEW R JOIN MEMBER_PROFILE P
    ON R.MEMBER_ID = P.MEMBER_ID
    GROUP BY R.MEMBER_ID
)

SELECT P.MEMBER_NAME, R.REVIEW_TEXT, DATE_FORMAT(R.REVIEW_DATE, '%Y-%m-%d') AS REVIEW_DATE
FROM REST_REVIEW R JOIN MEMBER_PROFILE P
ON R.MEMBER_ID = P.MEMBER_ID
WHERE R.MEMBER_ID IN (
    SELECT MEMBER_ID
    FROM REVIEW_RANK
    WHERE RANKING = 1
)
ORDER BY REVIEW_DATE, REVIEW_TEXT