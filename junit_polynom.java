package myMath;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class junit_polynom {

	@Test
	void testPolynomDefCtor() {
		Polynom p0=new Polynom();
		if(!p0.isZero()) {
			fail("p0 should equal to zero");
		}
	}
	
	@Test
	void testPolynomCopyCtor() {
		Polynom p0 = new Polynom("2x^2 + x + 5");
		Polynom p1 = new Polynom(p0);
		if (!p0.equals(p1))
			fail("p0 and p1 should be equal, copy ctor doesn't work.");
	}
	
	@Test
	void testPolynomStringCtor1() {
		Monom m0 = new Monom("3x^2");
		Monom m1 = new Monom("5x");
		Monom m2 = new Monom("7");
		Polynom p0 = new Polynom();
		p0.add(m0); p0.add(m1); p0.add(m2);
		Polynom p1 = new Polynom("3x^2 + 5x + 7");
		if (!p0.equals(p1))
			fail("Polynom is: " + p1 + " should be: " + p0);
	}
	
	@Test
	void testPolynomStringCtor2() {
		String[] bad_strings = {null, "", "3xx^4 + 5x", "x^4 -+5x", "-x^3 + %", "$^4 + ."};
		assertThrows(Exception.class,
	            ()->{
	            	for (int i = 0; i < bad_strings.length; i++) {
	            		new Polynom(bad_strings[i]);
					}
	            });
	}
	
	@Test
	void testPolynomStringCtor3() {
		String[] good_strings = {"0", "3x", "5x^3 + 2x + 5", "3x - 3", "-3x^2 - 2"};
		for (int i = 0; i < good_strings.length; i++) {
			try {
	        	new Polynom(good_strings[i]);
			}
			catch(Exception ex) {
				System.err.println(ex);
				fail("String should not throw exception ");
			}
		}
		
	}
	
	@Test
	void testPolynomValueAtX() {
		Polynom p = new Polynom("2x^2 + x + 5");
		double x = 2;
		double ans = 15;
		if (p.f(x) != ans) {
			fail("f(2) should equal " + ans + ", but equals " + p.f(x));
		}
	}
	
	@Test
	void testPolynomAddPolynom1() {
		Polynom p0 = new Polynom("2x^2 + x + 5");
		Polynom p1 = new Polynom("5x^3 + 5x");
		p1.add(p0);
		Polynom expected = new Polynom("5x^3 + 2x^2 + 6x + 5");
		if (!p1.equals(expected)) {
			fail("p1 should equal " + expected + ", but is equal to " + p1);
		}
	}
	
	@Test
	void testPolynomAddPolynom2() {
		Polynom p0 = new Polynom("2x^2 + x + 5");
		Polynom p1 = new Polynom("5x^3 - 5x");
		p1.add(p0);
		Polynom expected = new Polynom("5x^3 + 2x^2 - 4x + 5");
		if (!p1.equals(expected)) {
			fail("p1 should equal " + expected + ", but is equal to " + p1);
		}
	}
	
	@Test
	void testPolynomAddMonom1() {
		Polynom p = new Polynom("2x^2 + x + 5");
		Monom m = new Monom("7x^2");
		p.add(m);
		Polynom expected = new Polynom("9x^2 + x + 5");
		if (!p.equals(expected)) {
			fail("p1 should equal " + expected + ", but is equal to " + p);
		}
	}
	
	@Test
	void testPolynomAddMonom2() {
		Polynom p = new Polynom("2x^2 + x + 5");
		Monom m = new Monom("-7x^2");
		p.add(m);
		Polynom expected = new Polynom("-5x^2 + x + 5");
		if (!p.equals(expected)) {
			fail("p1 should equal " + expected + ", but is equal to " + p);
		}
	}
	
	@Test
	void testPolynomSubstractPolynom1() {
		Polynom p0 = new Polynom("2x^2 + x + 5");
		Polynom p1 = new Polynom("5x^3 + 5x");
		p1.substract(p0);
		Polynom expected = new Polynom("5x^3 - 2x^2 + 4x - 5");
		if (!p1.equals(expected)) {
			fail("p1 should equal " + expected + ", but is equal to " + p1);
		}
	}
	
	@Test
	void testPolynomSubstractPolynom2() {
		Polynom p0 = new Polynom("-2x^2 - x + 5");
		Polynom p1 = new Polynom("5x^3 - 5x");
		p1.substract(p0);
		Polynom expected = new Polynom("5x^3 + 2x^2 - 4x - 5");
		if (!p1.equals(expected)) {
			fail("p1 should equal " + expected + ", but is equal to " + p1);
		}
	}
	
	@Test
	void testPolynomSubstractMonom1() {
		Polynom p = new Polynom("2x^2 + x + 5");
		Monom m = new Monom("7x^2");
		p.substract(m);
		Polynom expected = new Polynom("-5x^2 + x + 5");
		if (!p.equals(expected)) {
			fail("p1 should equal " + expected + ", but is equal to " + p);
		}
	}
	
	@Test
	void testPolynomSubstractMonom2() {
		Polynom p = new Polynom("2x^2 + x + 5");
		Monom m = new Monom("-7x^2");
		p.substract(m);
		Polynom expected = new Polynom("9x^2 + x + 5");
		if (!p.equals(expected)) {
			fail("p1 should equal " + expected + ", but is equal to " + p);
		}
	}
	
	@Test
	void testPolynomMult1() {
		Polynom p0=new Polynom("3x^2 + 5x + 1");
		Polynom p1=new Polynom("5x^3 + 2x");
		Polynom p2=new Polynom("15x^5 + 25x^4 + 11x^3 + 10x^2 + 2x");
		p0.multiply(p1);
		if(!p0.equals(p2)) {
			fail(p0 + " should be equal to " + p2);
		}
	}
	
	void testPolynomMult2() {
		Polynom p0=new Polynom("3x^2 + 5x + 1");
		Polynom p1=new Polynom("5x^3 - 2x");
		Polynom p2=new Polynom("15x^5 + 25x^4 - x^3 - 10x^2 - 2x");
		p0.multiply(p1);
		if(!p0.equals(p2)) {
			fail(p0 + " should be equal to " + p2);
		}
	}
	
	@Test
	void testPolynomIsZero() {
		Polynom p0=new Polynom("0");
		if(!p0.isZero()) {
			fail("p0 should equal to zero");
		}
	}
	
	@Test
	void testPolynomEquals() {
		Polynom p0=new Polynom("3x^2 + 5x + 4");
		Polynom p1=new Polynom(p0);
		if(!p1.equals(p0)) {
			fail(p0 +" should be equal to " + p1);
		}
	}
	
	@Test
	void testPolynomDerivative() {
		Polynom p0 = new Polynom("3x^2 + 5x + 1");
		Polynom p1 = new Polynom("6x + 5");
		if (!p1.equals(p0.derivative())) {
			fail("The derivative should be " + p1 + " but is " + p0.derivative());
		}
	}
	
	@Test 
	void testPolynomToString1() {
		Monom m0 = new Monom("3x^2");
		Monom m1 = new Monom("5x");
		Monom m2 = new Monom("7");
		Polynom p0 = new Polynom();
		p0.add(m0); p0.add(m1); p0.add(m2);
		Polynom p1 = new Polynom(p0.toString());
		if (!p1.equals(p0)) {
			fail("p1 should equal" + p0 + " but is " + p1);
		}
	}
	
	@Test 
	void testPolynomToString2() {
		Monom m0 = new Monom("3x^2");
		Monom m1 = new Monom("-5x");
		Monom m2 = new Monom("-7");
		Polynom p0 = new Polynom();
		p0.add(m0); p0.add(m1); p0.add(m2);
		Polynom p1 = new Polynom(p0.toString());
		if (!p1.equals(p0)) {
			fail("p1 should equal" + p0 + " but is " + p1);
		}
	}
	
	@Test
	void testPolynomRoot() {
		double test_eps = 0.0001;
		double func_eps = 0.0001;
		Polynom p = new Polynom("x^3 - 2x^2 + 0.5");
		double expected = -0.4516;
		double ans = p.root(-0.6, -0.2, func_eps);
		if (!(ans >= expected-test_eps && ans <= expected+test_eps)) {
			fail("Answer should be between [" + (expected - test_eps) + "," + (expected + test_eps) + "]\nbut is " + ans);
		}
	}
	
	@Test
	void testPolynomArea() {
		double test_eps = 0.0001;
		double func_eps = 0.0001;
		Polynom p = new Polynom("x^3 - 2x^2 + 0.5");
		double expected = 0.342407;
		double ans = p.area(-0.6, 1, func_eps);
		if (!(ans >= expected-test_eps && ans <= expected+test_eps)) {
			fail("Answer should be between [" + (expected - test_eps) + "," + (expected + test_eps) + "]\nbut is " + ans);
		}
	}
	
	
}
