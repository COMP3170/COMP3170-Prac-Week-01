#version 410

uniform vec3 u_colour;
uniform vec2 u_screenSize;

layout(location = 0) out vec4 o_colour; // (r,g,b,a) (0-1,0-1,0-1,0-1)

void main()
{
	vec2 p = gl_FragCoord.xy / u_screenSize; // scale pixel location into a range of (0,0) to (1,1)
	vec2 offset = vec2(0.5,0.5f);

	o_colour = vec4(u_colour.rgb * p.y, 1.0f);
}