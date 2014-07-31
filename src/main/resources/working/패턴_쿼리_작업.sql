-- 윗꼬리 나란히
SELECT   Y.거래일자
            ,Y.종목코드
            ,Y.시가_당일, Y.시가_전일, Y.시가_전전일
            ,Y.고가_당일, Y.고가_전일, Y.고가_전전일
            ,Y.저가_당일, Y.저가_전일, Y.저가_전전일
            ,Y.종가_당일, Y.종가_전일, Y.종가_전전일
            ,Y.거래량_당일, Y.거래량_전일, Y.거래량_전전일
            ,Y.이동평균_5일
            ,Y.거래일자_5전일
FROM    (
				SELECT   X.거래일자
				            ,X.종목코드
				            ,X.시가_당일, X.시가_전일, X.시가_전전일
				            ,X.고가_당일, X.고가_전일, X.고가_전전일
				            ,X.저가_당일, X.저가_전일, X.저가_전전일
				            ,X.종가_당일, X.종가_전일, X.종가_전전일
				            ,X.거래량_당일, X.거래량_전일, X.거래량_전전일
				            ,(
				               SELECT CAST(AVG(T.종가) AS INT) 
				               FROM m_주식_가격_d T 
				               WHERE T.거래일자 BETWEEN  X.거래일자_5전일 AND X.거래일자 
				               AND T.종목코드 = X.종목코드
				              ) 이동평균_5일
				             ,X.거래일자_5전일
				FROM    (
								SELECT   A.거래일자
								            ,A.종목코드
								            ,A.시가_당일, A.시가_전일, A.시가_전전일
								            ,A.고가_당일, A.고가_전일, A.고가_전전일
								            ,A.저가_당일, A.저가_전일, A.저가_전전일
								            ,A.종가_당일, A.종가_전일, A.종가_전전일
								            ,A.거래량_당일, A.거래량_전일, A.거래량_전전일
								            ,A.거래일자_5전일
								FROM    (
												SELECT 
													[거래일자], 
													[종목코드], 
													[시가] AS 시가_당일, 
													LAG (시가, 1)  OVER (partition by 종목코드 order by 거래일자)  as 시가_전일,
													LAG (시가, 2)  OVER (partition by 종목코드 order by 거래일자)  as 시가_전전일,
													[고가] AS 고가_당일, 
													LAG (고가, 1)  OVER (partition by 종목코드 order by 거래일자)  as 고가_전일,
													LAG (고가, 2)  OVER (partition by 종목코드 order by 거래일자)  as 고가_전전일,
													[저가] AS 저가_당일, 
													LAG (저가, 1)  OVER (partition by 종목코드 order by 거래일자)  as 저가_전일,
													LAG (저가, 2)  OVER (partition by 종목코드 order by 거래일자)  as 저가_전전일,
													[종가] AS 종가_당일, 
													LAG (종가, 1)  OVER (partition by 종목코드 order by 거래일자)  as 종가_전일,
													LAG (종가, 2)  OVER (partition by 종목코드 order by 거래일자)  as 종가_전전일,
													[거래량] AS 거래량_당일, 
													LAG (거래량, 1)  OVER (partition by 종목코드 order by 거래일자)  as 거래량_전일,
													LAG (거래량, 2)  OVER (partition by 종목코드 order by 거래일자)  as 거래량_전전일,
													LAG (거래일자, 5)  OVER (partition by 종목코드 order by 거래일자)  AS 거래일자_5전일
												FROM 
													[m_주식_가격_d] 
												WHERE 거래일자 BETWEEN 20140610 AND 20140731	
												--AND 종목코드='016100'
								           ) A
								WHERE   A.거래일자_5전일 IS NOT NULL
								AND      A.종가_당일 > A.종가_전일
								AND      A.종가_전일 > A.종가_전전일
								AND      A.시가_당일 > A.시가_전일
								AND      A.시가_전일 > A.시가_전전일
								AND      A.고가_당일 < A.고가_전전일
								AND      A.고가_당일 > A.고가_전일
								AND      A.저가_당일 > A.저가_전일
								AND      A.저가_전일 > A.저가_전전일
								AND      A.거래량_당일 < A.거래량_전전일
								AND      A.거래량_전일 < A.거래량_전전일
								AND      A.거래량_전전일 > CAST(A.거래량_당일*1.5 AS INT)
								AND      A.거래량_전일 > CAST(A.거래량_당일*0.8 AS INT)
					         ) X
             	) Y
WHERE   Y.종가_전일 < Y.이동평균_5일              
AND       Y.종가_전전일 < Y.이동평균_5일              
ORDER BY 1,2

     

     
     
     
     
     
     