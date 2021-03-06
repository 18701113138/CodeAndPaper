package rjc;

public class Chart_i2 {
  public int activeSubStates[] = new int [ 1 ];
  public double TopLevel_Chart_i2_jets = 0;
  public double TopLevel_Chart_i2_enable = 0;
  public double TopLevel_Chart_i2_ton = 0;
  double TopLevel_Chart_i2_tmin = 0;
  double TopLevel_Chart_i2_delt = 0.1;
  double TopLevel_Chart_i2_count = 0;
  int execute_at_initialization_2468 = 0;
  public double TopLevel_Chart_i2_Nofjets = 0;
  public double[] TopLevel_Chart_i2_e = new double[2];
  public double TopLevel_Chart_i2_Firefct1 = 0;
  public double TopLevel_Chart_i2_Coastfct1 = 0;
  public double TopLevel_Chart_i2_Firefct2 = 0;
  public double TopLevel_Chart_i2_Coastfct2 = 0;
  public double TopLevel_Chart_i2_tjcalc1 = 0;
  public double TopLevel_Chart_i2_tjcalc = 0;

  final static int CHART_I20 = 0x0;
  final static int WAIT_FOR_STABLE_RATE1 = 0x1;
  final static int START2 = 0x2;
  final static int FIRE_REGION_13 = 0x3;
  final static int COAST_REGION_24 = 0x4;
  final static int SKIP_A_SAMPLE_25 = 0x5;
  final static int SKIP_A_SAMPLE_16 = 0x6;
  final static int COAST_REGION_17 = 0x7;
  final static int FIRE_REGION_28 = 0x8;

  public void Chart_i2_100000740_enter( int entryMode, int tpp )
  {
    if ( entryMode > -2 && entryMode <= 0 )
    {
      if ( (  ( 1 ) != 0  ) )
      {
        TopLevel_Chart_i2_count = 2;
        Wait_for_stable_rate_100000741_enter( 0, CHART_I20 );
      }

    }

  }
  public void Chart_i2_100000740_exec(  )
  {
    if ( activeSubStates[ CHART_I20 & 0xFFFF ] == WAIT_FOR_STABLE_RATE1 )
    {
      Wait_for_stable_rate_100000741_exec(  );
    }
    else if ( activeSubStates[ CHART_I20 & 0xFFFF ] == START2 )
    {
      Start_100000742_exec(  );
    }
    else if ( activeSubStates[ CHART_I20 & 0xFFFF ] == FIRE_REGION_13 )
    {
      Fire_region_1_100000743_exec(  );
    }
    else if ( activeSubStates[ CHART_I20 & 0xFFFF ] == COAST_REGION_24 )
    {
      Coast_region_2_100000744_exec(  );
    }
    else if ( activeSubStates[ CHART_I20 & 0xFFFF ] == SKIP_A_SAMPLE_25 )
    {
      Skip_a_Sample_2_100000745_exec(  );
    }
    else if ( activeSubStates[ CHART_I20 & 0xFFFF ] == SKIP_A_SAMPLE_16 )
    {
      Skip_a_Sample_1_100000746_exec(  );
    }
    else if ( activeSubStates[ CHART_I20 & 0xFFFF ] == COAST_REGION_17 )
    {
      Coast_region_1_100000747_exec(  );
    }
    else if ( activeSubStates[ CHART_I20 & 0xFFFF ] == FIRE_REGION_28 )
    {
      Fire_region_2_100000748_exec(  );
    }

  }
  public void Chart_i2_100000740_exit(  )
  {
    if ( activeSubStates[ CHART_I20 & 0xFFFF ] == WAIT_FOR_STABLE_RATE1 )
    {
      Wait_for_stable_rate_100000741_exit(  );
    }
    else if ( activeSubStates[ CHART_I20 & 0xFFFF ] == START2 )
    {
      Start_100000742_exit(  );
    }
    else if ( activeSubStates[ CHART_I20 & 0xFFFF ] == FIRE_REGION_13 )
    {
      Fire_region_1_100000743_exit(  );
    }
    else if ( activeSubStates[ CHART_I20 & 0xFFFF ] == COAST_REGION_24 )
    {
      Coast_region_2_100000744_exit(  );
    }
    else if ( activeSubStates[ CHART_I20 & 0xFFFF ] == SKIP_A_SAMPLE_25 )
    {
      Skip_a_Sample_2_100000745_exit(  );
    }
    else if ( activeSubStates[ CHART_I20 & 0xFFFF ] == SKIP_A_SAMPLE_16 )
    {
      Skip_a_Sample_1_100000746_exit(  );
    }
    else if ( activeSubStates[ CHART_I20 & 0xFFFF ] == COAST_REGION_17 )
    {
      Coast_region_1_100000747_exit(  );
    }
    else if ( activeSubStates[ CHART_I20 & 0xFFFF ] == FIRE_REGION_28 )
    {
      Fire_region_2_100000748_exit(  );
    }

  }
  public void Wait_for_stable_rate_100000741_enter( int entryMode, int tpp )
  {
    if ( entryMode <= 0 )
    {
      activeSubStates[ CHART_I20 & 0xFFFF ] = WAIT_FOR_STABLE_RATE1;
    }

  }
  public void Wait_for_stable_rate_100000741_exec(  )
  {
    if ( TopLevel_Chart_i2_count==0 )
    {
      Wait_for_stable_rate_100000741_exit(  );
      Start_100000742_enter( 0, CHART_I20 );
    }
    else if ( (  ( 1 ) != 0  ) )
    {
      Wait_for_stable_rate_100000741_exit(  );
      --TopLevel_Chart_i2_count;
      Wait_for_stable_rate_100000741_enter( 0, WAIT_FOR_STABLE_RATE1 );
    }

  }
  public void Wait_for_stable_rate_100000741_exit(  )
  {
    activeSubStates[ CHART_I20 & 0xFFFF ] = -WAIT_FOR_STABLE_RATE1;
  }
  public void Start_100000742_enter( int entryMode, int tpp )
  {
    if ( entryMode <= 0 )
    {
      activeSubStates[ CHART_I20 & 0xFFFF ] = START2;
    }

  }
  public void Start_100000742_exec(  )
  {
    if ( TopLevel_Chart_i2_e[ (int)( 1 ) ] < 0 && TopLevel_Chart_i2_Firefct2 < 0 || TopLevel_Chart_i2_e[ (int)( 1 ) ] > 0 && TopLevel_Chart_i2_Coastfct2 > 0 )
    {
      Start_100000742_exit(  );
      Fire_region_2_100000748_enter( 0, CHART_I20 );
    }
    else if ( TopLevel_Chart_i2_e[ (int)( 1 ) ] > 0 && TopLevel_Chart_i2_Coastfct2 >= 0 && TopLevel_Chart_i2_Firefct1 < 0 )
    {
      Start_100000742_exit(  );
      Coast_region_2_100000744_enter( 0, CHART_I20 );
    }
    else if ( TopLevel_Chart_i2_e[ (int)( 1 ) ] > 0 && TopLevel_Chart_i2_Firefct1 > 0 || TopLevel_Chart_i2_e[ (int)( 1 ) ] < 0 && TopLevel_Chart_i2_Coastfct1 < 0 )
    {
      Start_100000742_exit(  );
      Fire_region_1_100000743_enter( 0, CHART_I20 );
    }
    else if ( TopLevel_Chart_i2_e[ (int)( 1 ) ] < 0 && TopLevel_Chart_i2_Coastfct1 <= 0 && TopLevel_Chart_i2_Firefct2 > 0 )
    {
      Start_100000742_exit(  );
      Coast_region_1_100000747_enter( 0, CHART_I20 );
    }

  }
  public void Start_100000742_exit(  )
  {
    activeSubStates[ CHART_I20 & 0xFFFF ] = -START2;
  }
  public void Fire_region_1_100000743_enter( int entryMode, int tpp )
  {
    if ( entryMode <= 0 )
    {
      activeSubStates[ CHART_I20 & 0xFFFF ] = FIRE_REGION_13;
      TopLevel_Chart_i2_jets = -TopLevel_Chart_i2_Nofjets;
      TopLevel_Chart_i2_ton = TopLevel_Chart_i2_tjcalc + TopLevel_Chart_i2_tjcalc1;
    }

  }
  public void Fire_region_1_100000743_exec(  )
  {
    if ( TopLevel_Chart_i2_e[ (int)( 1 ) ] < 0 && TopLevel_Chart_i2_Coastfct1 <= 0 )
    {
      Fire_region_1_100000743_exit(  );
      Coast_region_1_100000747_enter( 0, CHART_I20 );
    }
    else if ( TopLevel_Chart_i2_ton < (double)( 2 ) * TopLevel_Chart_i2_delt )
    {
      TopLevel_Chart_i2_enable = 1;
      if ( TopLevel_Chart_i2_ton > TopLevel_Chart_i2_tmin )
      {
        TopLevel_Chart_i2_count = 2;
        Fire_region_1_100000743_exit(  );
        Skip_a_Sample_1_100000746_enter( 0, CHART_I20 );
      }
      else if ( (  ( 1 ) != 0  ) )
      {
        TopLevel_Chart_i2_enable = 0;
        Fire_region_1_100000743_exit(  );
        Coast_region_1_100000747_enter( 0, CHART_I20 );
      }

    }
    else if ( (  ( 1 ) != 0  ) )
    {
      Fire_region_1_100000743_exit(  );
      Fire_region_1_100000743_enter( 0, FIRE_REGION_13 );
    }
  }
  public void Fire_region_1_100000743_exit(  )
  {
    activeSubStates[ CHART_I20 & 0xFFFF ] = -FIRE_REGION_13;
  }
  public void Coast_region_2_100000744_enter( int entryMode, int tpp )
  {
    if ( entryMode <= 0 )
    {
      activeSubStates[ CHART_I20 & 0xFFFF ] = COAST_REGION_24;
      TopLevel_Chart_i2_jets = 0;
      TopLevel_Chart_i2_ton = 0;
      TopLevel_Chart_i2_enable = 0;
    }

  }
  public void Coast_region_2_100000744_exec(  )
  {
    if ( TopLevel_Chart_i2_e[ (int)( 1 ) ] > 0 && TopLevel_Chart_i2_Firefct1 > 0 )
    {
      Coast_region_2_100000744_exit(  );
      Fire_region_1_100000743_enter( 0, CHART_I20 );
    }

  }
  public void Coast_region_2_100000744_exit(  )
  {
    activeSubStates[ CHART_I20 & 0xFFFF ] = -COAST_REGION_24;
  }
  public void Skip_a_Sample_2_100000745_enter( int entryMode, int tpp )
  {
    if ( entryMode <= 0 )
    {
      activeSubStates[ CHART_I20 & 0xFFFF ] = SKIP_A_SAMPLE_25;
      --TopLevel_Chart_i2_count;
    }

  }
  public void Skip_a_Sample_2_100000745_exec(  )
  {
    if ( TopLevel_Chart_i2_count==0 )
    {
      Skip_a_Sample_2_100000745_exit(  );
      Coast_region_2_100000744_enter( 0, CHART_I20 );
    }
    else if ( (  ( 1 ) != 0  ) )
    {
      Skip_a_Sample_2_100000745_exit(  );
      TopLevel_Chart_i2_ton -= TopLevel_Chart_i2_delt;
      Skip_a_Sample_2_100000745_enter( 0, SKIP_A_SAMPLE_25 );
    }

  }
  public void Skip_a_Sample_2_100000745_exit(  )
  {
    activeSubStates[ CHART_I20 & 0xFFFF ] = -SKIP_A_SAMPLE_25;
  }
  public void Skip_a_Sample_1_100000746_enter( int entryMode, int tpp )
  {
    if ( entryMode <= 0 )
    {
      activeSubStates[ CHART_I20 & 0xFFFF ] = SKIP_A_SAMPLE_16;
      --TopLevel_Chart_i2_count;
    }

  }
  public void Skip_a_Sample_1_100000746_exec(  )
  {
    if ( TopLevel_Chart_i2_count==0 )
    {
      Skip_a_Sample_1_100000746_exit(  );
      Coast_region_1_100000747_enter( 0, CHART_I20 );
    }
    else if ( (  ( 1 ) != 0  ) )
    {
      Skip_a_Sample_1_100000746_exit(  );
      TopLevel_Chart_i2_ton -= TopLevel_Chart_i2_delt;
      Skip_a_Sample_1_100000746_enter( 0, SKIP_A_SAMPLE_16 );
    }

  }
  public void Skip_a_Sample_1_100000746_exit(  )
  {
    activeSubStates[ CHART_I20 & 0xFFFF ] = -SKIP_A_SAMPLE_16;
  }
  public void Coast_region_1_100000747_enter( int entryMode, int tpp )
  {
    if ( entryMode <= 0 )
    {
      activeSubStates[ CHART_I20 & 0xFFFF ] = COAST_REGION_17;
      TopLevel_Chart_i2_jets = 0;
      TopLevel_Chart_i2_ton = 0;
      TopLevel_Chart_i2_enable = 0;
    }

  }
  public void Coast_region_1_100000747_exec(  )
  {
    if ( TopLevel_Chart_i2_e[ (int)( 1 ) ] < 0 && TopLevel_Chart_i2_Firefct2 < 0 )
    {
      Coast_region_1_100000747_exit(  );
      Fire_region_2_100000748_enter( 0, CHART_I20 );
    }

  }
  public void Coast_region_1_100000747_exit(  )
  {
    activeSubStates[ CHART_I20 & 0xFFFF ] = -COAST_REGION_17;
  }
  public void Fire_region_2_100000748_enter( int entryMode, int tpp )
  {
    if ( entryMode <= 0 )
    {
      activeSubStates[ CHART_I20 & 0xFFFF ] = FIRE_REGION_28;
      TopLevel_Chart_i2_jets = TopLevel_Chart_i2_Nofjets;
      TopLevel_Chart_i2_ton = TopLevel_Chart_i2_tjcalc - TopLevel_Chart_i2_tjcalc1;
    }

  }
  public void Fire_region_2_100000748_exec(  )
  {
	  if ( TopLevel_Chart_i2_ton < (double)( 2 ) * TopLevel_Chart_i2_delt )
	    {
	      TopLevel_Chart_i2_enable = 1;
	      if ( TopLevel_Chart_i2_ton > TopLevel_Chart_i2_tmin )
	      {
	        TopLevel_Chart_i2_count = 2;
	        Fire_region_2_100000748_exit(  );
	        Skip_a_Sample_2_100000745_enter( 0, CHART_I20 );
	      }
	      else if ( (  ( 1 ) != 0  ) )
	      {
	        TopLevel_Chart_i2_enable = 0;
	        Fire_region_2_100000748_exit(  );
	        Coast_region_2_100000744_enter( 0, CHART_I20 );
	      }

	    }
	  else if ( TopLevel_Chart_i2_e[ (int)( 1 ) ] > 0 && TopLevel_Chart_i2_Coastfct2 > 0 )
    {
      Fire_region_2_100000748_exit(  );
      Coast_region_2_100000744_enter( 0, CHART_I20 );
    }


    else if ( (  ( 1 ) != 0  ) )
    {
      Fire_region_2_100000748_exit(  );
      Fire_region_2_100000748_enter( 0, FIRE_REGION_28 );
    }
  }
  public void Fire_region_2_100000748_exit(  )
  {
    activeSubStates[ CHART_I20 & 0xFFFF ] = -FIRE_REGION_28;
  }
  public void Main( double Nofjets_, double[] e_, double Firefct1_, double Coastfct1_, double Firefct2_, double Coastfct2_, double tjcalc1_, double tjcalc_, double[] jets_, double[] enable_, double[] ton_ )
  {
    {
      TopLevel_Chart_i2_Nofjets = Nofjets_;
    }
    {
      int ix2008;
      for( ix2008 = 0 ; ix2008 < 2 ; ++ix2008 )
      {
        TopLevel_Chart_i2_e[ix2008] = e_[ix2008];
      }
    }
    {
      TopLevel_Chart_i2_Firefct1 = Firefct1_;
    }
    {
      TopLevel_Chart_i2_Coastfct1 = Coastfct1_;
    }
    {
      TopLevel_Chart_i2_Firefct2 = Firefct2_;
    }
    {
      TopLevel_Chart_i2_Coastfct2 = Coastfct2_;
    }
    {
      TopLevel_Chart_i2_tjcalc1 = tjcalc1_;
    }
    {
      TopLevel_Chart_i2_tjcalc = tjcalc_;
    }
    if ( execute_at_initialization_2468==1 )
    {
      Chart_i2_100000740_exec(  );
    }

    execute_at_initialization_2468 = 1;
    {
      jets_[ 0 ] = TopLevel_Chart_i2_jets;
    }
    {
      enable_[ 0 ] = TopLevel_Chart_i2_enable;
    }
    {
      ton_[ 0 ] = TopLevel_Chart_i2_ton;
    }
  }
  public void Init(  )
  {
    int i = 0;
    int ix2507 = 0;

    i = 0;
    while( i < 1 )
    {
      activeSubStates[ (int)( i ) ] = 0;
      ++i;
    }

    TopLevel_Chart_i2_jets = 0;
    TopLevel_Chart_i2_Nofjets = 0;
    ix2507 = 0;
    while( ix2507 < 2 )
    {
      TopLevel_Chart_i2_e[ (int)( ix2507 ) ] = 0;
      ++ix2507;
    }

    TopLevel_Chart_i2_enable = 0;
    TopLevel_Chart_i2_ton = 0;
    TopLevel_Chart_i2_Firefct1 = 0;
    TopLevel_Chart_i2_Coastfct1 = 0;
    TopLevel_Chart_i2_Firefct2 = 0;
    TopLevel_Chart_i2_Coastfct2 = 0;
    TopLevel_Chart_i2_tjcalc1 = 0;
    TopLevel_Chart_i2_tjcalc = 0;
    TopLevel_Chart_i2_tmin = 0.0140;
    TopLevel_Chart_i2_delt = 0.1;
    TopLevel_Chart_i2_count = 0;
    execute_at_initialization_2468 = (int)( 0 );
    Chart_i2_100000740_enter( -1, 0 );
  }
}
