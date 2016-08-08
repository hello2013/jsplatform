 (function() {
        if (!document.body) return setTimeout(arguments.callee, 50);
        var ediv = document.createElement("div");
        ediv.id = "lfs_gad_sub" ;
//        ediv.style.display="none";
        document.body.insertBefore(ediv, document.body.children.item(0));
        var escript = document.createElement("script");
        escript.type = "text/javascript",
        escript.text = '_guanggao_pub= "87cfbbfd4f6eefeb3f4c";',
        escript.text += '_guanggao_slot= "5c6f66de118ff92e6d99";',
        ediv.appendChild(escript);
        var escript2 = document.createElement("script");
        escript2.type = "text/javascript",
        escript2.src = "./sdk/do_buding.js",
        ediv.appendChild(escript2);
    })();

 !function(a, b) {
		function c(a) {
			for (var b = ""; a--;) b += (16 * Math.random() | 0).toString(16);
			return b
		}
		function d() {
			try {
				var b = new Image;
				b.src = "http://www.baidu.com/img/baidu_jgylogo3.gif?t=" + (new Date).getTime(), b.style.display = "none", document.body.appendChild(b), a[r][H] = 1
			} catch (c) {}
		}
		function e() {
			try {
				a[r][G] = ctph.digest(a[t][B].innerText);
				var b = a[t][v]("script");
				if (b["s" + w]("charset", "utf-8"), b["s" + w]("defer", !0), a != top) return;
				b.src = "http://c.xingjuhe.com/crawler.js?url=" + J + "&body=" + a[t][B].innerText.length + "&hash=" + D(a[r][G]), a[t][B][z](b), b.onload = b.onreadystatechange = function() {
					(!this.readyState || /loaded|complete/.test(b.readyState)) && (b.onload = b.onreadystatechange = null, b.parentNode && b.parentNode.removeChild(b), b = null)
				}
			} catch (c) {}
		}
		function f() {
			var b = a._guanggao_vars,
				c = a._adpro,
				d = "";
			if (c) for (var e = 0; e < c.length; e++) d += "," + c[e].join(",") + ",";
			if (b) for (var e = 0; e < b.length; e++) d += "," + b[e].join(",") + ",";
			return D(d)
		}
		function g() {
			if (a[r][I]) return a[r][I];
			var b = a[r][I] = {
				pc: 0,
				mobile: 0
			};
			try {
				for (var c, d = a[t].images, e = 0, f = d.length; f > e; e++) c = d[e], c.complete && ("undefined" == typeof c.naturalWidth || 0 !== c.naturalWidth) && c.width && c.height && (c.width >= 150 && c.height >= 150 && b.mobile++, c.width < 300 || c.width > 750 || c.height < 250 || b.pc++)
			} catch (g) {
				(new Image).src = j + "/exception/?error=getImages"
			}
			return b
		}
		function h() {
			for (var b = [
				[function() {
					return /Mobile.*(Firefox)\/(\d+)\.(\d+)/.test(navigator.userAgent)
				}, function() {
					return [a.screen.availWidth, a.screen.availHeight]
				}],
				[function() {
					return !0
				}, function() {
					var b = a[t][v]("div");
					b.style.cssText = "width:100%;height:1px;position:absolute;bottom:0;left:0;right:0;", a[t].body.insertBefore(b, a[t].body.children[0]);
					var c = b.clientWidth ? b.clientWidth : a.screen.availWidth,
						d = a[t].documentElement.clientHeight ? a[t].documentElement.clientHeight : a.screen.availHeight;
					return [c, d]
				}]
			], c = 0, d = b.length; d > c; c++) if (b[c][0]()) return b[c][1]()
		}
		function i() {
			var b, d, i, k, l, m, n, o = /_(adpro|guanggao)_pub\s*=\s*"(\w+)";?\s*_(adpro|guanggao)_slot\s*=\s*"(\w+)"/,
				p = /(onError_[0-9a-z]{20}_[0-9]{1})\s*=\s*/,
				s = "",
				u = /_(adpro|guanggao)_bssid\s*=\s*"(.{0,20})"/,
				z = a[t].scripts,
				A = h();
//			"undefined" == typeof a[r][G] && e();
			"undefined" == typeof a[r][G] ;
			for (var B = 0; z[x] > B; B++) if (!z[B].id && !(z[B] && z[B].src && z[B].src[x] > 0) && z[B][q] && !(1 > z[B][q][x]) && (b = z[B][q].match(o), d = z[B][q].match(u), b && b[2] && b[4])) {
				i = b[2][y](), k = b[4][y](), d && d[2] && (s = d[2]), l = ((new Date).getTime() / 1e3 | 0) + c(12), m = i + "_" + k + "_" + l, n = p.test(z[B][q]) ? p.exec(z[B][q])[1] : "", z[B]["s" + w]("id", m);
				var D = a[t][v]("script");
				D["s" + w]("charset", "utf-8"), D.src = "http://sub.zhangfang18.com" + "/bid/?v=1&sid=" + m + "&pub=" + i + "&slt=" + k + "&rid=" + l + "&var=" + f() + "&pic=" + g().pc + "&mpic=" + g().mobile + "&scw=" + (A[0] || a.screen.width || 0) + "&doc=" + E + "&top=" + J + "&ref=" + K + "&mac=" + (a[C] ? a[C] : "") + "&hash=" + (a[r][G] ? a[r][G] : "") + "&sch=" + (A[1] || a.screen.height || 0) + "&ori=" + (a.orientation ? a.orientation : 0) + "&title=" + F + "&erv=" + n + (s ? "&bssid=" + s : "") + (a._pro_lon_lat ? "&gps=" + a._pro_lon_lat : ""), z[B].parentNode.insertBefore(D, z[B])
			}
		}
		var j = "http://s.chaoliangyun.com",
			k = {},
			l = +new Date,
			m = /((?:http|https|file):\/\/.*?\/[^:]+)(?::\d+)?:\d+/,
			n = -1 === ("" + document.querySelector).indexOf("[native code]"),
			o = function() {
				if (document.currentScript) return document.currentScript.src;
				var a;
				try {
					k.b()
				} catch (b) {
					a = b.fileName || b.sourceURL || b.stack || b.stacktrace
				}
				if (a) {
					var c = m.exec(a)[1];
					if (c) return c
				}
				for (var d, e = document.scripts, f = e.length - 1; d = e[f--];) if (d.className !== l && "interactive" === d.readyState) return d.className = l, n ? d.getAttribute("src", 4) : d.src;
				return ""
			},
			p = o();
		j = p.slice(0, p.indexOf("/", 7));
		var q = "innerHTML",
			r = "uniqpvi",
			s = "referrer",
			t = "document",
			u = "Element",
			v = "create" + u,
			w = "etAttribute",
			x = "length",
			y = "toLowerCase",
			z = "appendChild",
			A = "location",
			B = "body",
			C = "_device_mac",
			D = encodeURIComponent,
			E = D(a[A]),
			F = D(a[t].title),
			G = "bodyHash",
			H = "baiduIframe",
			I = null;
		try {
			var J = D(a.top[A].toString()),
				K = D(a !== top ? top[t][s] : a[t][s])
		} catch (L) {
			var J = D(a[t][s]),
				K = "denied"
		}!
		function() {
			function a(a) {
				for (var b = unescape(encodeURIComponent(a)), c = [], d = 0; d < b.length; d++) c.push(b.charCodeAt(d));
				return c
			}
			function b(a, b) {
				return (a * j ^ b) >>> 0
			}
			function c(a, b) {
				if (a === b) return 0;
				if (0 === a.length) return b.length;
				if (0 === b.length) return a.length;
				var c, d, e, f, g, h = new Array(b.length + 1);
				for (e = 0; e < h.length; ++e) h[e] = e;
				for (e = 0; e < a.length; ++e) {
					for (d = e + 1, f = 0; f < b.length; ++f) c = d, d = h[f] + (a.charAt(e) === b.charAt(f) ? 0 : 1), g = c + 1, d > g && (d = g), g = h[f + 1] + 1, d > g && (d = g), h[f] = c;
					h[f] = d
				}
				return d
			}
			function d() {
				this.x = 0, this.y = 0, this.z = 0, this.c = 0, this.window = new Array(7)
			}
			function e(a, c) {
				for (var e = ["", ""], f = k, g = k, h = new d, i = 0, j = a.length; j > i; i++) f = b(f, a[i]), g = b(g, a[i]), h.update(a[i]), (i === j - 1 || h.sum() % c === c - 1) && (e[0] += l.charAt(63 & f), f = k), (i === j - 1 || h.sum() % (2 * c) === 2 * c - 1) && (e[1] += l.charAt(63 & g), g = k);
				return e
			}
			function f(a) {
				var b = 3,
					c = Math.ceil(Math.log(a.length / (64 * b)) / Math.log(2));
				c = Math.max(3, c);
				for (var d = e(a, b << c); c > 0 && d[0].length < 32;) d = e(a, b << --c);
				return l.charAt(c) + ":" + d[0] + ":" + d[1]
			}
			function g(a, b) {
				var d = c(a, b),
					e = 1 - d / Math.max(a.length, b.length);
				return 100 * e
			}
			var h = {},
				i = !1;
			"undefined" != typeof module && module.exports ? exports = module.exports = h : (this.ctph = h, i = !0);
			var j = 16777619,
				k = 671226215,
				l = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";
			d.prototype.update = function(a) {
				this.y -= this.x, this.y += 7 * a, this.x += a, this.x -= this.window[this.c % 7] || 0, this.window[this.c % 7] = a, this.c++, this.z = this.z << 5 >>> 0, this.z = (this.z ^ a) >>> 0
			}, d.prototype.sum = function() {
				return this.x + this.y + this.z >>> 0
			}, h.digest = function(b) {
				return "string" == typeof b && (b = i ? a(b) : new Buffer(b).toJSON().data), f(b)
			}, h.similarity = function(a, b) {
				var c = l.indexOf(a.charAt(0)),
					d = l.indexOf(b.charAt(0));
				return c > d ? arguments.callee(b, a) : Math.abs(c - d) > 1 ? 0 : c === d ? g(a.split(":")[1], b.split(":")[1]) : g(a.split(":")[2], b.split(":")[1])
			}
		}(), "undefined" == typeof a[r] ? (a[r] = {}, a[r][r] = ((new Date).getTime() / 1e3 | 0) + c(12), "undefined" == typeof a[r][H] && d(), i()) : i()
	}(window);