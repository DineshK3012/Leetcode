    for(int a : ages)
        cnt[a]++;
    
    vector<int> accsum(121, 0);
    for(int i = 15; i < 121; i++)
        accsum[i] = cnt[i] + accsum[i-1];
    
    int res = 0;
    for(int i = 15; i < 121; i++){
        res += cnt[i] * (accsum[i] - accsum[(i>>1)+7]) - cnt[i];
    }
    
    return res;
}