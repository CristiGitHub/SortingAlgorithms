package Sortari;

public class PerlinNoise {
	private float x;
	private float y;
	
	
PerlinNoise randomGr(int x,int y)
{
	//Wikipedia zice ca e ok :D
	float rd =(float) (2920.f * Math.sin(x*21942.f+y*171324.f+8912.f)*Math.cos(x*23157.f*y*217832.f+9758.f));
	PerlinNoise pr = new PerlinNoise();
	pr.x=(float) Math.sin(rd);
	pr.y=(float) Math.sin(rd);
	return pr;
}
float randomGrD(int x, int y, float a , float b)
{
	 PerlinNoise gradient = randomGr(x, y);
	    float dx = x - (float)a;
	    float dy = y - (float)b;
	    return (dx*gradient.x + dy*gradient.y);
}

float perlin(float x, float y) {

    int x0 = (int)x;
    int x1 = x0 + 1;
    int y0 = (int)y;
    int y1 = y0 + 1;
    float sx = x - (float)x0;
    float sy = y - (float)y0;
    float n0, n1, val1, val2;
    n0 = randomGrD(x0, y0, x, y);
    n1 = randomGrD(x1, y0, x, y);
    val1= (n0-n1)*sx+n0;
    n0 = randomGrD(x0, y1, x, y);
    n1 = randomGrD(x1, y1, x, y);
    val2= (n0-n1)*sx+n0;
    return (val1-val2)*sy+val1;
}

}
