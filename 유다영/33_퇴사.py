n = int(input())
work_list = [list(map(int,input().split())) for _ in range(n)]

dp = [0]*(n+1) # 최대의 수입을 저장하기 위한 dp 테이블

for day in range(n-1, -1, -1):
    t = work_list[day][0] # 상담 소요일
    # 해당 일에 근무하는 경우
    if day+t <= n:
        p = work_list[day][1] # 상담 수입
        # 최대 이익 선택
        dp[day]=max(dp[day+1], dp[day+t]+p)
    # 해당 일에 근무하지 않는 경우
    else:
        dp[day]=dp[day+1]
print(dp[0])
