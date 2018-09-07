var renderChart = function (apiUrl) {
    var svg = d3.select("svg"),
        margin = {top: 20, right: 20, bottom: 30, left: 50},
        width = +svg.attr("width") - margin.left - margin.right,
        height = +svg.attr("height") - margin.top - margin.bottom,
        g = svg.append("g").attr("transform", "translate(" + margin.left + "," + margin.top + ")");

    var parseTime = d3.utcParse("%Y-%m-%dT%H:%M:%S.%L");
    var timeFormat = d3.timeFormat("%X");
    var numberFormat = d3.format(".2f");

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

    var div = d3.select("body").append("div")
        .attr("class", "tooltip")
        .style("opacity", 0);

    d3.json(apiUrl, function (error, data) {
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
            .attr("class", "axis")
            .call(d3.axisBottom(x))
            .select(".domain");
            // .remove();

        g.append("g")
            .call(d3.axisLeft(y))
            .append("text")
            .attr("class", "axis.y")
            .attr("y", 8)
            .attr("dy", "0.71em")
            .text("Price ($)");

        g.append("path")
            .datum(data)
            .attr("class", "line")
            .attr("d", line);

        g.selectAll("dot")
            .data(data)
            .enter()
            .append("circle")
            .attr("class", "dot")
            .attr("r", 3)
            .attr("cx", function(d) { return x(d.time); })
            .attr("cy", function(d) { return y(d.buy); })
            .on("mouseover", function (d) {
                console.log(d);
                div.transition()
                    .duration(200)
                    .style("opacity", .9);
                div.html(timeFormat(d.time) + "<br/>" + numberFormat(d.buy))
                    .style("left", (d3.event.pageX) + "px")
                    .style("top", (d3.event.pageY - 28) + "px");
            })
            .on("mouseout", function (d) {
                div.transition()
                    .duration(500)
                    .style("opacity", 0);
            });
    });
};

var updateChart = function () {
    d3.selectAll("g").remove();
    renderChart("http://javaschool:8081/todayRates");
};

var updateChartByLastHour = function () {
    d3.selectAll("g").remove();
    renderChart("http://javaschool:8081/lastHourRates");
};

var updateChartByLastFiveMinutes = function () {
    d3.selectAll("g").remove();
    renderChart("http://javaschool:8081/lastFiveMinutesRates");
};

var updateChartByLastMinute = function () {
    d3.selectAll("g").remove();
    renderChart("http://javaschool:8081/lastMinuteRates");
};