var renderChart = function () {
    var svg = d3.select("svg"),
        margin = {top: 20, right: 20, bottom: 30, left: 50},
        width = +svg.attr("width") - margin.left - margin.right,
        height = +svg.attr("height") - margin.top - margin.bottom,
        g = svg.append("g").attr("transform", "translate(" + margin.left + "," + margin.top + ")");

    var parseTime = d3.utcParse("%Y-%m-%dT%H:%M:%S.%L");

    var x = d3.scaleTime()
        .rangeRound([0, width]);

    var y = d3.scaleLinear()
        .rangeRound([height, 0]);

    var line = d3.line()
        .x(function (d) {
            return x(d.time);
        })
        .y(function (d) {
            return y(d.buy);
        });

    d3.json("http://javaschool:8081/rates", function (error, data) {
        if (error) throw error;
        data.forEach(function (d) {
            d.time = parseTime(d.time);
            d.buy = +d.buy;
            return d;
        });
        console.log(data);

        x.domain(d3.extent(data, function (d) {
            return d.time;
        }));
        y.domain(d3.extent(data, function (d) {
            return d.buy;
        }));

        g.append("g")
            .attr("transform", "translate(0," + height + ")")
            .call(d3.axisBottom(x))
            .select(".domain")
            .remove();

        g.append("g")
            .call(d3.axisLeft(y))
            .append("text")
            .attr("fill", "#000")
            .attr("transform", "rotate(-90)")
            .attr("y", 6)
            .attr("dy", "0.71em")
            .attr("text-anchor", "end")
            .text("Price ($)");

        g.append("path")
            .datum(data)
            .attr("class", "line")
            // .attr("fill", "none")
            // .attr("stroke", "steelblue")
            // .attr("stroke-linejoin", "round")
            // .attr("stroke-linecap", "round")
            // .attr("stroke-width", 1.5)
            .attr("d", line);
    });
};

var updateChart = function () {
    var svg = d3.selectAll("g").remove(),
        margin = {top: 20, right: 20, bottom: 30, left: 50};

    svg = d3.select("svg");
    var g = svg.append("g").attr("transform", "translate(" + margin.left + "," + margin.top + ")"),
        width = +svg.attr("width") - margin.left - margin.right,
        height = +svg.attr("height") - margin.top - margin.bottom;

    var parseTime = d3.utcParse("%Y-%m-%dT%H:%M:%S.%L");

    var x = d3.scaleTime()
        .rangeRound([0, width]);

    var y = d3.scaleLinear()
        .rangeRound([height, 0]);

    var line = d3.line()
        .x(function (d) {
            return x(d.time);
        })
        .y(function (d) {
            return y(d.buy);
        });

    d3.json("http://javaschool:8081/todayRates", function (error, data) {
        if (error) throw error;
        data.forEach(function (d) {
            d.time = parseTime(d.time);
            d.buy = +d.buy;
            return d;
        });
        console.log(data);

        x.domain(d3.extent(data, function (d) {
            return d.time;
        }));
        y.domain(d3.extent(data, function (d) {
            return d.buy;
        }));

        g.append("g")
            .attr("transform", "translate(0," + height + ")")
            .call(d3.axisBottom(x))
            .select(".domain")
            .remove();

        g.append("g")
            .call(d3.axisLeft(y))
            .append("text")
            .attr("fill", "#000")
            .attr("transform", "rotate(-90)")
            .attr("y", 6)
            .attr("dy", "0.71em")
            .attr("text-anchor", "end")
            .text("Price ($)");

        g.append("path")
            .datum(data)
            .attr("fill", "none")
            .attr("stroke", "steelblue")
            .attr("stroke-linejoin", "round")
            .attr("stroke-linecap", "round")
            .attr("stroke-width", 1.5)
            .attr("d", line);
    });
};

var updateChartByLastHour = function () {
    var svg = d3.selectAll("g").remove(),
        margin = {top: 20, right: 20, bottom: 30, left: 50};

    svg = d3.select("svg");
    var g = svg.append("g").attr("transform", "translate(" + margin.left + "," + margin.top + ")"),
        width = +svg.attr("width") - margin.left - margin.right,
        height = +svg.attr("height") - margin.top - margin.bottom;

    var parseTime = d3.utcParse("%Y-%m-%dT%H:%M:%S.%L");

    var x = d3.scaleTime()
        .rangeRound([0, width]);

    var y = d3.scaleLinear()
        .rangeRound([height, 0]);

    var line = d3.line()
        .x(function (d) {
            return x(d.time);
        })
        .y(function (d) {
            return y(d.buy);
        });

    d3.json("http://javaschool:8081/lasHourRates", function (error, data) {
        if (error) throw error;
        data.forEach(function (d) {
            d.time = parseTime(d.time);
            d.buy = +d.buy;
            return d;
        });
        console.log(data);

        x.domain(d3.extent(data, function (d) {
            return d.time;
        }));
        y.domain(d3.extent(data, function (d) {
            return d.buy;
        }));

        g.append("g")
            .attr("transform", "translate(0," + height + ")")
            .call(d3.axisBottom(x))
            .select(".domain")
            .remove();

        g.append("g")
            .call(d3.axisLeft(y))
            .append("text")
            .attr("fill", "#000")
            .attr("transform", "rotate(-90)")
            .attr("y", 6)
            .attr("dy", "0.71em")
            .attr("text-anchor", "end")
            .text("Price ($)");

        g.append("path")
            .datum(data)
            .attr("fill", "none")
            .attr("stroke", "steelblue")
            .attr("stroke-linejoin", "round")
            .attr("stroke-linecap", "round")
            .attr("stroke-width", 1.5)
            .attr("d", line);
    });
};