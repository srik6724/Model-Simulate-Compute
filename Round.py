import pyreason as pr

pr.load_graphml('file.graphml')
pr.add_rule(pr.Rule('popular(x) <-1 popular(y), Friends(x,y), owns(y,z), owns(x,z)', 'popular_rule'))
pr.add_fact(pr.Fact(name='popular-fact', component='Mary', attribute='popular', bound=[1, 1], start_time=0, end_time=2))
interpretation = pr.reason(timesteps=2)
