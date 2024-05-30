        Polynomial result = p1.add(p2);

        for (int i = 0; i < result.coef.length; i++) {
            System.out.println(result.coef[i]);
            System.out.println(result.exp[i]);
        }