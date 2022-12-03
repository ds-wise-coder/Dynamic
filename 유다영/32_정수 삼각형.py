# 정수 삼각형의 계산 방법의 경로를 역추적 하면 바로 위에서 오거나, 그 옆에서 오는 2가지 경우임
# 양끝에 있는 건 예외처리한다.

n = int(input())
triangle = [list(map(int, input().split())) for _ in range(n)]
# print(t)

dp = [[0] * n for _ in range(n)]  # n층 n개의 dp table==cache
visited = 0  # 방문체크


def dfs(floor, num):
    # 종료조건: 마지막 층, 마지막 요소까지 다 했을때
    if floor == (n - 1):
        return triangle[floor][num]
    # dp table 이용
    if dp[floor][num] != 0:
        return dp[floor][num]
    # 가지치기
    dp[floor][num] = max(dp[floor][num], dfs(floor + 1, num) + triangle[floor][num])
    dp[floor][num] = max(dp[floor][num], dfs(floor + 1, num + 1) + triangle[floor][num])
    return dp[floor][num]


# Top-down 방식으로 0층에 0번째 요소부터 시작
print(dfs(0, 0))
